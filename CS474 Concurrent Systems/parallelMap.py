import multiprocessing as mp
import numpy as np
import time

arr = np.random.randint(0, 10, size=[200000, 5])
data = arr.tolist()
data[:5]

def howmany_within_range_rowonly(row, minimum=4, maximum=8):
    count = 0
    for n in row:
        if minimum <= n <= maximum:
            count = count + 1
    return count

def main():
	results = []
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = pool.map(howmany_within_range_rowonly, [row for row in data])
	pool.close() 
	end = time.time()
	duration = end - start

	print("Parallel using Map: ", results[:10],int(1000*duration),"ms")

if __name__ == '__main__':
	main()
	input() 