import multiprocessing as mp
import numpy as np
import time

arr = np.random.randint(0, 10, size=[200000, 5])
data = arr.tolist()
data[:5]

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
	pool = mp.Pool(mp.cpu_count())
	results = pool.starmap(howmany_within_range, [(row, 4, 8) for row in data])
	pool.close() 
	end = time.time()
	duration = end - start

	print("Parallel using Starmap: ", results[:10],int(1000*duration),"ms")

if __name__ == '__main__':
	main()
	input() 