from flask import Flask, abort, jsonify
import json


app = Flask(__name__)


votes = [
    {
        'post_id': 0,
        'vote_count': -1,
    },
    {
        'post_id': 1,
        'vote_count': 5,
    },
    {
        'post_id': 2,
        'vote_count': 42,
    },
]


@app.route('/api/vote_count/', methods=["GET"])
def plural_get():
	return jsonify(votes)

@app.route('/api/vote_count/<int:id>', methods=["GET"])
def singular_get(id):
	return jsonify(votes[id])