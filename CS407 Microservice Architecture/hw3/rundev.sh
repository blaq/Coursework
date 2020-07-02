#!/usr/bin/env bash
export FLASK_APP=activity_logger.py
export FLASK_ENV=development
export DB=activity_log_dev
export HOST=mongodb://localhost:27017/

flask run --host=0.0.0.0 --port 5001
