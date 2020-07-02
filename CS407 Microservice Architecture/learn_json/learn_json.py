import json

def main():
	with open('grades.json') as f:
		grades = json.load(f)
	for grade in grades:
		if grade["class_id"] == 28:
			if grade["scores"][0]["type"] == "exam":
				print("Student ",grade["student_id"]," exam score:")
				print(grade["scores"][0]["score"])

if __name__ == "__main__":
	main()