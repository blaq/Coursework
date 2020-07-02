from mongoengine import connect, StringField, IntField, Document
from datetime import datetime

connect(db="activity_log", host="localhost")

class ActivityLog(Document):
    user_id = IntField(required=True)
    username = StringField(required=True, max_length=64)
    timestamp = DateTimeField(default=datetime.utcnow)
    details = StringField(required=True)