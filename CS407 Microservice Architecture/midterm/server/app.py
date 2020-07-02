from flask import Flask, jsonify, request
import json

app = Flask(__name__)

@app.route('/api/stringdata/<string:word>', methods=["GET"])
def string_manipulate(word):

	return jsonify(word)