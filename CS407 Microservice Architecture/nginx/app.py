from flask import Flask, jsonify, request
import json

def manipulate(res):
	attributes = {
			'length': len(res),
			'reversed': res[::-1],
			'upper': res.upper(),
	}
	return attributes

app = Flask(__name__)

@app.route('/api/stringdata/<string:res>', methods=["GET"])
def string_manipulate(res):

	return jsonify(manipulate(res))