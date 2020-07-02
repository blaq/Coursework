#!/usr/bin/env bash
export FLASK_APP=activity_logger.py
export FLASK_ENV=development
export DB_HOST=ds217864.mlab.com:17864
export DB=activity-logger-dev
export DB_USER=user_1
export DB_PASSWORD=p4ssw0rd
export SLEEP_TIME=5

flask run --host=0.0.0.0 --port 5001
