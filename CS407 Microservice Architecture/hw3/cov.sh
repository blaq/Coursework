#!/bin/bash
export FLASK_APP=activity_logger.py
coverage run --source "." -m py.test
coverage html
xdg-open htmlcov/index.html
