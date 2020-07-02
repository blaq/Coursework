from datetime import datetime

def get_timestamp():
    return datetime.now().strftime(("%Y-%m-%d %H:%M:%S"))

# Data to serve with our API
POSTS = {
    "0": {
        "id": 0,
        "location": "north",
        "user_id": 0,
        "username": "guy",
        "timestamp": get_timestamp(),
        "details": "none"
    },
    "1": {
        "id": 1,
        "location": "south",
        "user_id": 1,
        "username": "gal",
        "timestamp": get_timestamp(),
        "details": "none"
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