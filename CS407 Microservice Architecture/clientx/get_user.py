import sys
import json
import requests

def main():
	url = "https://jsonplaceholder.typicode.com/users/"+sys.argv[1]
	print(url)
	r = requests.get(url)
	j = json.loads(r.text)
	print(j)

if __name__ == "__main__":
	main()