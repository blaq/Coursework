import multiprocessing as mp
import time

def exponent(x):
	return x*x

def main():
	naturalNumbers = [x for x in range(200000)]
	results = []
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = pool.map(exponent, naturalNumbers)
	pool.close() 
	end = time.time()
	duration = end - start

	print("Parallel using Map: ", results[:10],int(1000*duration),"ms")
if __name__ == '__main__':
	main()
	input() 