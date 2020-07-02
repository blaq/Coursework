import multiprocessing as mp
import numpy as np
import time

# create a list of 20,000 lists with 5 random numbers 
arr = np.random.randint(0, 10, size=[200000, 5])
data = arr.tolist()
data[:5]

#####################################No Paralleization################################################
# Sequential

def howmany_within_range(row, minimum, maximum):
    """Returns how many numbers lie within `maximum` and `minimum` in a given `row`"""
    count = 0
    for n in row:
        if minimum <= n <= maximum:
            count = count + 1
    return count

def main():
	results = []
	start = time.time()
	for row in data:
		results.append(howmany_within_range(row, minimum=4, maximum=8))
	end = time.time()
	duration = end - start

	print("Without Parallelization: ", results[:10],int(1000*duration),"ms")

if __name__ == '__main__':
	main()
	input() 