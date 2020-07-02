import json, requests

def main():
	r = requests.get('https://reqres.in/api/users/').json()
	print(r["data"][1]["first_name"], r["data"][1]["last_name"])

if __name__ == "__main__":
	main()