from mongoengine import connect, StringField, IntField, Document, DateTimeField
from flask import Flask, jsonify, abort, request, url_for
from datetime import datetime
import json
import time
import os
from dotenv import load_dotenv

log = Flask(__name__)

load_dotenv(override=True)

mongo_host = os.getenv('DB_HOST')
mongo_db = os.getenv('DB')
mongo_user = os.getenv('DB_USER')
mongo_password = os.getenv('DB_PASSWORD')

connect(db=mongo_db,
        host=mongo_host,
        username=mongo_user,
        password=mongo_password)

sleep_time = os.getenv('SLEEP_TIME', default=0)

class ActivityLog(Document):
    user_id = IntField(required=True)
    username = StringField(required=True, max_length=64)
    timestamp = DateTimeField(required=True)
    details = StringField(required=True)

def class_to_dict(activity):
    id = str(activity.to_mongo().to_dict().pop("_id", None))
    activity_dict = {
        "id": id,
        "location": "/api/activities/"+id,
        "user_id": activity["user_id"],
        "username": activity["username"],
        "timestamp": activity["timestamp"],
        "details": activity["details"],
        "version": "2.0",
    }  
    return activity_dict

@log.route('/api/activities/', methods=["GET"])
def get_mult_activities(n=10):
    latest = ActivityLog.objects.all().order_by("-timestamp").limit(n)
    ls = []
    for Document in latest:
        ls.append(class_to_dict(Document))
    return jsonify(ls)

@log.route('/api/activities/<string:id>', methods=["GET"])
def get_single_activity(id):
    activity = ActivityLog.objects.get(id=id)
    activity_dict = class_to_dict(activity)
    return jsonify(activity_dict)

@log.route('/api/activities/', methods=["POST"])
def post_activity():
    if not request.json:
        abort(400)
    new_act = request.get_json()
    #print(new_act)
    if "user_id" not in new_act or "username" not in new_act or "details" not in new_act or "timestamp" not in new_act:
        abort(401)

    activity = ActivityLog(
        user_id=new_act["user_id"],
        username=str(new_act["username"]),
        timestamp=new_act["timestamp"],
        details=str(new_act["details"]),
    )
    activity.save()
    time.sleep(int(sleep_time))
    
    activity_dict=class_to_dict(activity)
    return jsonify(activity_dict), 201