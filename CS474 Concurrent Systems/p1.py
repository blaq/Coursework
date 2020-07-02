import math
import time
import multiprocessing as mp

size = 100

def sequentialPrimes():
	ls = [1 for i in range(size)]
	ls[0] = ls[1] = 0
	for i in range(2, int(math.sqrt(size))):
		for j in range(i*i, size, i):
			ls[j] = 0;
	return sum(ls)

def worker(ls, cut, num):
		#for j in range(i*i, size, i):
	region = len(ls)*cut
	#print(region)
	for i in range(2, int(math.sqrt(size))+1,1):
		offset = region-(region%i)
		#print(offset)
		for j in range(offset+i, len(ls)+region, i):
			ls[j-region] = 0
			print(i,offset,"j:",j," - r:",region," = ",j-region)

	return ls

def parallelPrimes():
	ls = [1]*size
	processors = 4
	cut = int(size/4)+1
	lists = []
	for n in range(processors):
		lists.append(ls[(cut*n):(cut*n+cut)-1])
		#print(len(ls[(cut*n):(cut*n+cut)]))
	final =[]
	for n in range(processors):
		print("hello")
		final += worker(lists[n], cut, n)

	final[2] = final[3] = final[5] = final[7] = 1
	final[0] = final[1] = 0
	for one in range(len(final)):
		if final[one] == 1:
			print(one)
	print(final)
	print(sum(final))

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