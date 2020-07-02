import multiprocessing as mp
import time

def exponent(x):
	time.sleep(1)
	return x*x

def main():
	naturalNumbers = [x for x in range(1,10)]
	results = []
	
	pool = mp.Pool(mp.cpu_count())
	start = time.time()
	results = pool.map(exponent, naturalNumbers)
	end = time.time()
	pool.close() 
	duration = end - start

	print("Parallel using Map: ", results[:10],int(1000*duration),"ms")
if __name__ == '__main__':
	main()
	input() 