#!/bin/bash
export LOG_URL="https://activitylogger-ethan-cs407.herokuapp.com"
celery -A app.models worker --loglevel=info