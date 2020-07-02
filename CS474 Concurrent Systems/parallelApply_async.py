import multiprocessing as mp
import numpy as np
import time

arr = np.random.randint(0, 10, size=[200, 5])
data = arr.tolist()
data[:5]

def howmany_within_range2(i, row, minimum, maximum):
    """Returns how many numbers lie within `maximum` and `minimum` in a given `row`"""
    count = 0
    for n in row:
        if minimum <= n <= maximum:
            count = count + 1
    return (i, count)

results = []
# Step 2: Define callback function to collect the output in `results`
def collect_result(result):
    global results
    results.append(result)

def main():

	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	for i, row in enumerate(data):
		pool.apply_async(howmany_within_range2, args=(i, row, 4, 8), callback=collect_result)

	# Step 4: Close Pool and let all the processes complete    
	pool.close()
	pool.join()
	results.sort(key=lambda x: x[0])
	results_final = [r for i, r in results] 
	end = time.time()
	duration = end - start

	print("Parallel using Apply_async: ", results[:10],int(1000*duration),"ms")

if __name__ == '__main__':
	main()
	input()