
def divisors(num):
	factors = []
	for i in range(1, num+1):
		if (num % i) == 0:
			factors.append(i)
	
	divisor_list = {
			'divisors': [factors]
	}
	return factors