import pytest
from app.helpers import pretty_date
from datetime import datetime, timedelta


def test_datetime():
	assert (pretty_date(datetime.utcnow())) == "just now"

def test_seconds():
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=10))) == "10 seconds ago"
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=59))) == "59 seconds ago"

def test_single_minute():
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=60))) == "a minute ago"
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=119))) == "a minute ago"

def test_mult_minutes():
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=120))) == "2 minutes ago"
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=3599))) == "59 minutes ago"

def test_single_hour():
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=3600))) == "an hour ago"
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=7199))) == "an hour ago"

def test_mult_hours():
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=7200))) == "2 hours ago"
	assert (pretty_date(datetime.utcnow() - timedelta(seconds=14400))) == "4 hours ago"


def test_yesterday():
	assert (pretty_date(datetime.utcnow() - timedelta(days=1))) == "Yesterday"

def test_days():
	assert (pretty_date(datetime.utcnow() - timedelta(days=2))) == "2 days ago"
	assert (pretty_date(datetime.utcnow() - timedelta(days=6))) == "6 days ago" 

def test_weeks():
	assert (pretty_date(datetime.utcnow() - timedelta(days=7))) == "1 weeks ago"
	assert (pretty_date(datetime.utcnow() - timedelta(days=30))) == "4 weeks ago"

def test_months():
	assert (pretty_date(datetime.utcnow() - timedelta(days=31))) == "1 months ago"
	assert (pretty_date(datetime.utcnow() - timedelta(days=364))) == "12 months ago"

def test_years():
	assert (pretty_date(datetime.utcnow() - timedelta(days=365))) == "1 years ago"
	assert (pretty_date(datetime.utcnow() - timedelta(days=1000))) == "2 years ago"
