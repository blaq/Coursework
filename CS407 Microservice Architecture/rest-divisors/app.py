from flask import Flask, jsonify, abort, request, url_for
import json
from divisors import divisors

div = Flask(__name__)

@div.route('/api/divisors/<int:num>', methods=["GET"])
def get_divisors(num):
	return jsonify(divisors(num))