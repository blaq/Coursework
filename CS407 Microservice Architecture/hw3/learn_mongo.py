from mongoengine import connect, StringField, IntField, Document

connect(db="dogs", host="localhost")

class DogBreed(Document):
	breed = StringField(required=True, max_length=64)
	style = StringField(max_length=255)
	number_of_subspecies = IntField()

b = DogBreed(
	breed="retriever",
	style="red",
	number_of_subspecies=5
)

b.save()
