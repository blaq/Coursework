#!/bin/bash
export WOLFIT_SETTINGS=$(pwd)/test.settings
export FLASK_ENV=test
export FLASK_DEBUG=0
export LOG_URL=https://activitylogger-ethan-cs407.herokuapp.com/
pytest -x $@
