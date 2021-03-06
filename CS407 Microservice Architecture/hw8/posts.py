from datetime import datetime

def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))

# Data to serve with our API
POSTS = {
    "0": {
        "id": 7,
        "title": "horizontal input questions",
        "link": False,
        "url": "NULL",
        "timestamp": get_timestamp(),
        "user_id": 2,
        "category_id": 1,
        "vote_count": 0,
    },
    "1": {
        "id": 25,
        "title": "how do I loop this",
        "link": False,
        "url": "NULL",
        "timestamp": get_timestamp(),
        "user_id": 2,
        "category_id": 1,
        "vote_count": 0,
    },
}

# Create a handler for our read (GET) people
def read():
    """
    This function responds to a request for /api/people
    with the complete lists of people

    :return:        sorted list of people
    """
    # Create the list of people from our data
    return [POSTS[key] for key in sorted(POSTS.keys())]