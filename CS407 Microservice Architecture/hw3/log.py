from flask import Flask, jsonify, abort, request, url_for
from datetime import datetime

log = Flask(__name__)

activity_log = [
    {
        'id': 0,
        'user_id': 1,
        'username': 'john',
        'timestamp': datetime.utcnow(),
        'details': "Important stuff here",
    },
    {
        'id': 1,
        'user_id': 2,
        'username': 'yoko',
        'timestamp': datetime.utcnow(),
        'details': "Even more important",
    },
]

@log.route('/api/activities/', methods=["GET"])
def get_mult_activities():
	return jsonify({'activities': activity_log})

@log.route('/api/activities/<int:id>', methods=["GET"])
def get_single_activity(id):
	if id < 0 or id >= len(activity_log):
		abort(404)
	return jsonify(activity_log[id])

@log.route('/api/activities', methods=["POST"])
def post_activity():
	if not request.json:
		abort(400)
	new_act = request.get_json()
	if 'username' not in new_act or 'details' not in new_act :
		abort(400)
	new_act['id'] = len(activity_log)
	new_act['user_id'] = len(activity_log) + 1
	new_act['timestamp'] = datetime.utcnow()
	return jsonify(request.json)