#!/bin/bash
export WOLFIT_SETTINGS=$(pwd)/dev.settings
export LOG_URL="https://activitylogger-ethan-cs407.herokuapp.com"
celery -A app.models worker --loglevel=info &
flask run --host=0.0.0.0 && fg