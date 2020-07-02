#!/bin/bash
coverage run --omit __init__.py --source "." -m py.test
coverage html
xdg-open htmlcov/index.html
