from mongoengine import connect, StringField, IntField, Document, DateTimeField
from datetime import datetime
import json


connect(db="activity_log_dev", host="localhost")

class ActivityLog(Document):
    user_id = IntField(required=True)
    username = StringField(required=True, max_length=64)
    timestamp = DateTimeField(default=datetime.utcnow)
    details = StringField(required=True)

#a = ActivityLog(
#	user_id=1,
#	username="a",
#	details="test_a",
#)
#a.save()

#b = ActivityLog(
#	user_id=2,
#	username="b",
#	details="test_b",
#)
#b.save()


act = ActivityLog.objects[0].to_mongo().to_dict()["_id"]

print(act)
#ActivityLog[0].to_mongo().to_dict()["username"]
#posts = db.activity_log

#print(posts.count())

#print(posts.find_one({'user_id': 1}))

print(f'"hello"')