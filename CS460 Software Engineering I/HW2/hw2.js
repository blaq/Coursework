
function getCurrentDate()
{
	var currentDate = new Date();
	var dd = String(currentDate.getDate()).padStart(2, '0');
	var mm = String(currentDate.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = currentDate.getFullYear();
	var dateString = mm + '/' + dd + '/' + yyyy;

	var hh = String(currentDate.getHours()).padStart(2, '0');
	var min = String(currentDate.getMinutes()).padStart(2, '0'); //January is 0!
	var ss = String(currentDate.getSeconds()).padStart(2, '0');
	var timeString = hh + ':' + min + ':' + ss;

	$('#date').val(dateString);
	$('#time').val(timeString);
}

function getCustomDate()
{
	$("ul").remove();
	$("#errors").after("<br><ul></ul>");

	var date = document.getElementById('date').value;
	if (date.length < 10 || date.length > 10)
	{
		$("ul").append("<li>Date entry is the wrong length.\nPlease use the format:\nMM/DD/YYYY</li>");
	}

	else
	{
		var year = Number(date.substring(6, 10));
		year = checkVaildFormat("year", 0, 2050, year);

		var month = Number(date.substring(0, 2));
		month = checkVaildFormat("month", 1, 12, month);

		var day = Number(date.substring(3, 5));
		var numDays = new Date(year, month, 0).getDate();
		day = checkVaildFormat("day", 1, numDays, day);
	}

	var time = document.getElementById('time').value;
	if (time.length < 8 || time.length > 8)
	{
		$("ul").append("<li>Time entry is the wrong length.\nPlease use the format:\nHH:MM:SS</li>");
	}

	else
	{
		var hour = Number(time.substring(0, 2));
		hour = checkVaildFormat("hour", 0, 23, hour);
		var radio = document.querySelector('input[name="half"]:checked').value;
		if (hour < 12)
		{
			hour = hour + radio;
		}
		if (hour == 12 && radio == 0)
		{
			hour = hour - 12; 
		}

		var minute = Number(time.substring(3, 5));
		minute = checkVaildFormat("minute", 0, 59, minute);

		var second = Number(time.substring(6, 8));
		second = checkVaildFormat("second", 0, 59, second);
	}	

	var customDateTime = new Date(year, month, day, hour, minute, second);
	if (customDateTime != "Invalid Date")
	{
		getSunStats(customDateTime);
	}
	else
	{
		$('#first').remove()
		$('#second').remove()
		$("#results").remove();
	}
}

function checkVaildFormat(str, left, right, input)
{
	if (isNaN(input) || input < left || input > right)
	{
		$("ul").append("<li>Invalid "+str+".\nEnter a "+str+" between "+left+"-"+right+"</li>");
		return NaN;
	}
	return input;
}

function getSunStats(datetime)
{
	var julianDate = getJulianDate(datetime);
	var n = julianDate - 2451545;
	var L = getMeanLongitude(n);
	var g = getMeanAnomaly(n);
	var lambda = L + (1.915 * Math.sin(g)) + (.02 * Math.sin(2*g));
	var B = 0;
	var R = 1.00014 - (.01671 * Math.cos(g)) - (.00014 * Math.cos(2*g));

	$('#first').remove()
	$('#second').remove()
	$("#resultsHeader").after("<h3 id=\"first\">On "+datetime.toDateString()+"");
	$("#first").after("<h3 id=\"second\">At "+datetime.toLocaleTimeString()+"")

	$("#results").remove();
	$("#resultsRow").after("<table id=\"results\"></table>");
	$("#results").append("<tr><td>Julian Date</td>\n<td id=\"r\">"+cleaner(julianDate)+" days</td></tr>");
	$("#results").append("<tr><td>Sun's Mean Longitude</td>\n<td id=\"r\">"+cleaner(L)+"&deg;</td></tr>");
	$("#results").append("<tr><td>Sun's Mean Anomaly</td>\n<td id=\"r\">"+cleaner(g)+"&deg;</td></tr>");
	$("#results").append("<tr><td>Sun's Ecliptic Longitude</td>\n<td id=\"r\">"+cleaner(lambda)+"&deg;</td></tr>");
	$("#results").append("<tr><td>Sun's Ecliptic Latitude</td>\n<td id=\"r\">"+cleaner(B)+"&deg;</td></tr>");
	$("#results").append("<tr><td>Distance to the Sun</td>\n<td id=\"r\">"+cleaner(R)+" AU</td></tr>");
}

function cleaner(num)
{
	return Math.round(num * 1000) / 1000;
}

function getJulianDate(datetime) 
{
	var julian = 4713;
	var totalYears = 4713 + 1900 + datetime.getYear() - 1;
	var commonYears = 0;
	var leapYears = 0;
	for (y=0; y < julian+1582; y++)
	{
		if (y%4 != 1)
		{
			commonYears++;
		}
		else
		{
			leapYears++;
		}
	}

	for (y=julian+1582; y < totalYears; y++)
	{
		if (y%4 != 0)
		{
			commonYears++;
		}
		else if (y%100 != 0)
		{
			leapYears++;
		}
		else if (y%400 != 0)
		{
			commonYears++;
		}
		else
		{
			leapYears++;
		}
	}

	var totalDays = (365 * commonYears) + (366 * leapYears) - 10; //julian to gregorian
	var yearStartTime = new Date(datetime.getFullYear(), 0, 0);
	var difference = (datetime - yearStartTime) + ((yearStartTime.getTimezoneOffset() - datetime.getTimezoneOffset()) * 60 * 1000);
	var currentYearDays = Math.floor(difference / (1000 * 60 * 60 * 24))
	var totalDays = totalDays + currentYearDays + 1;

	if (datetime.getSeconds() >= 12 * 3600)
	{
		var totalSeconds = datetime.getSeconds() - (12 * 3600);
	}
	else
	{
		totalDays--;
		var totalSeconds = datetime.getSeconds() + (12 * 3600);
	}
	
	var julianDate = totalDays + (totalSeconds/86400);
	return julianDate;
}

function getMeanLongitude(julianDate)
{
	var longitude = 280.460 + (.9856474 * julianDate)
	
	if (longitude < 0)
	{
		longitude = longitude * -1;
	}
	while (longitude > 360)
	{
		longitude = longitude - 360
	}
	return longitude;
}

function getMeanAnomaly(julianDate)
{
	var g = 357.528 + (.9856003 * julianDate)
	
	if (g < 0)
	{
		g = g * -1;
	}
	while (g > 360)
	{
		g = g - 360
	}
	return g;
}
