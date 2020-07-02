from flask import Flask, jsonify, abort, request, url_for
from datetime import datetime
from mongoengine import connect, StringField, IntField, Document, DateTimeField

app = Flask (__name__)

connect(db="activity_log_dev", host="localhost")

#Class Struct for Activity Logger
class ActivityLogger(Document):
    user_id = IntField(required=True)
    username = StringField(required=True, max_length=64)
    timestamp = DateTimeField(default=datetime.utcnow)
    details = StringField(required=True)

#Return a single activity by a specified ID.
@app.route('/api/activities/<int:id>', methods=["GET"])
def activity(id):
    return jsonify(ActivityLogger(id=id))


#Returns all activities in a list.
@app.route('/api/activities/', methods=["GET"])
def activities():
    return jsonify({"activitylog": ActivityLogger()})

#Create a new activity, should not contain an ID that is system generated.
#Return the created activity as JSON with ID populated.
@app.route("/api/activities/", methods=["POST"])
def new_activity():
    if not request.json:
        abort(400, "Request not in JSON format")
    new_activity = request.get_json()
    if "username" not in new_activity or "user_id" not in new_activity or "details" not in new_activity:
        abort(400, "Missing key elements")

    # Base instance of ativity log
    activity_log = ActivityLogger(
        user_id=new_activity["user_id"],
        username=new_activity["username"],
        details=new_activity["details"]
    )

    # Saves base instance
    activity_log.save()

    return jsonify(new_activity), 201