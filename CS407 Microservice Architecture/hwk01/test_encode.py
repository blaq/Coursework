
from encode import encode


def test_empty_string():
	assert encode("") == ""

def test_non_repeating_string():
	# non-repeating strings will always return the input string 
	assert encode("a") == "a"
	assert encode("abc") == "abc"
	assert encode("aba") == "aba"

def test_compression():
	assert encode("aabbbccccddddd") == "a2b3c4d5"
	assert encode("zzzzzyyyyxxxww") == "z5y4x3w2"
	assert encode("abbbabbbbabbbbba") == "a1b3a1b4a1b5a1"

def test_edges_of_compression():
	assert encode("abbbbbbc") == "a1b6c1"
	assert encode("aabbbbcc") == "a2b4c2"
	assert encode("aaaab") == "a4b1"
	assert encode("abbbb") == "a1b4"

def test_case_of_chars():
	assert encode("aAaaaaa") == "a1A1a5"
	assert encode("AaAAAAA") == "A1a1A5"

def test_size_of_compression():
	assert encode("aa") == "aa"
	assert encode("aaa") == "a3"
	assert encode("abb") == "abb"

def test_final_solution():
	assert encode("abcdefghijklmnopqrstuvwxyz") == "abcdefghijklmnopqrstuvwxyz"
	assert encode("aaaaab") == "a5b1" 
	assert encode("aaaaaa") == "a6"
	assert encode("aabcccccaaa") == "a2b1c5a3"
