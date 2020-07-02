$.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/api/user',
    success: showUser,
    error: errorOnAjax
});

function errorOnAjax() {
    console.log('Error on AJAX return');
}

function showUser(data) {
    $('#user-1').append('<img src="' + data.avatar_url + '" id="user-pic" alt="user_pic">');
    $('#user-2').append('<h2>' + data.name + '</h2>');
    $('#user-2').append('<p>' + data.username + '</p>');
    $('#user-2').append('<p>' + data.email + '</p>');
    $('#user-2').append('<p>' + data.company + '</p>');
    $('#user-2').append('<p>' + data.location + '</p>');
}


$.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/api/repositories',
    success: showRepos,
    error: errorOnAjax
});

function showRepos(data) {
    data.sort(sortByDate);
    for (var d in data) {
        $('#repos').append('<li id="repo-' + d + '"></li>');
        $('#repo-' + d).append('<h2><a href="' + data[d].html_url + '" class="stop">' + data[d].name + '</h2>');
        $('#repo-' + d).append('<p><img src ="' + data[d].owner_avatar_url + '" alt="img" id="thumbnail"></p>');
        $('#repo-' + d).append('<p>' + data[d].owner + '</p>');
        $('#repo-' + d).append('<p>' + data[d].updated_at + '</p>');
        $('#repo-' + d).append('<input class="commitsButton" type="button" value="commits" onclick="showCommits(\''
                                                                + data[d].owner + '\', \'' + data[d].name + '\');" />');
    }
}

function showCommits(user, repo) {
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/api/commits?user=' + user + '&repo=' + repo,
        success: function (data) {
            data.sort(sortByDate);
            $("#commits").empty();
            $(".title").remove();
            $("<h2 class=\"title\">Commit History</h2>").insertBefore("#commits");
            $('#commits').append('<tr><th>hash</th><th>timestamp</th><th>commiter</th><th>message</th></tr>');
            
            for (var d in data) {
                $('#commits').append('<tr class="commit">');
                $('#commits').append('<td class="commit"><a href="' + data[d].html_url + '" class="stop">' + data[d].sha.substr(0, 8) + '</a></td>');
                $('#commits').append('<td class="commit">' + data[d].date + '</td>');
                $('#commits').append('<td class="commit">' + data[d].committer + '</td>');
                $('#commits').append('<td class="commit">' + data[d].message + '</td>');
                $('#commits').append('</tr>');
            }
        },
        error: errorOnAjax
    });
}

function sortByDate(a, b) {
    return new Date(b.updated_at).getTime() - new Date(a.updated_at).getTime();
}