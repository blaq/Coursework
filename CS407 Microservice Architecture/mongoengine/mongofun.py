from mongoengine import *
import os
from datetime import datetime
from dotenv import load_dotenv

load_dotenv(override=True)


mongo_host = os.getenv('DB_HOST')
mongo_db = os.getenv('DB')
mongo_user = os.getenv('DB_USER')
mongo_password = os.getenv('DB_PASSWORD')


connect(db=mongo_db,
		host=mongo_host,
		username=mongo_user,
		password=mongo_password)


class BusinessProject(Document):
	owner_id = IntField(required=True)
	project_name = StringField(required=True, max_length=64)
	due_date = DateTimeField(default=datetime.utcnow)
	project_details = StringField(required=True)


try:
	BusinessProject.objects.get(owner_id=5)
except DoesNotExist:
	project = BusinessProject(
		owner_id=5,
		project_name='me',
		project_details='detailed',
	)
	project.save()
else:
	print("exists")


retrieve = BusinessProject.objects.get(owner_id=1)
print(retrieve["owner_id"])
print(retrieve["project_name"])
print(retrieve["due_date"])
print(retrieve["project_details"])
