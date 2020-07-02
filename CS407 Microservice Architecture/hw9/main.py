import requests
import json
import time
import os
import sys, traceback

def main():
	url = "http://localhost:8080/api/activities/5c057f23e116f3000bd1ffd9"
	print(f"Accessing posts on: {url}")
	print("[ctrl+c to stop]")
	while True:
		time.sleep(2)
		r = requests.get(url)
		if r.status_code == 201 or r.status_code == 200:
			data = json.loads(r.text)
			version = data['version']
			print(f"Version: {version}")
			if version == "2.0":
				print(f" user_id: {data['user_id']}")
		else:
			print("unable to GET activity data")
	return

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('[stopped]')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)