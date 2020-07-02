import math
import time
import multiprocessing as mp

size = 100000

def sequentialPrimes():
	ls = [1 for i in range(size)]
	ls[0] = ls[1] = 0
	for i in range(2, int(math.sqrt(size))):
		for j in range(i*i, size, i):
			ls[j] = 0;
	return sum(ls)

def init(a):
	global array
	array = a

def worker(i):
	if array[i] == 1:
		for j in range(i*i, size, i):
			array[j] = 0
	return

def parallelPrimes():
	processors = 4
	array = mp.Array('i', [1]*size, lock=False)
	pool = mp.Pool(processes=processors, initializer=init, initargs=(array,))
	pool.map(worker, range(2,int(math.sqrt(size))))
	array[0] = array[1] = 0
	return sum(array)

def runTests(func):
	tests = 1
	duration = []
	for t in range(tests):
		start = time.time()
		nPrimes = func()
		end = time.time()
		duration.append(end - start)
	averageDuration = sum(duration) / tests
	return nPrimes, averageDuration

def main():
	seq, seqTime = runTests(sequentialPrimes)
	par, parTime = runTests(parallelPrimes)

	print(f"num: {size}")
	print(f"seq: {seq} in an average of {seqTime} seconds")
	print(f"par: {par} in an average of {parTime} seconds")

if __name__ == '__main__':
	main()