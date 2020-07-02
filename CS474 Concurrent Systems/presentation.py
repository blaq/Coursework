import multiprocessing as mp
import time

def exponent(x):
	time.sleep(.1)
	return x*x

def showSeq(N):
	start = time.time()
	results = [exponent(x) for x in N]
	end = time.time()
	duration = end - start
	print("Sequential:\t\t\t", results[:10],int(1000*duration),"ms")
	return

def showApply(N):
	results = []
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = [pool.apply(exponent, args=(x,)) for x in N]
	pool.close() 
	end = time.time()
	duration = end - start
	print("Parallel using Apply:\t\t", results[:10],int(1000*duration),"ms")
	#input()
	return

def showMap(N):
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = pool.map(exponent, N)
	pool.close() 
	end = time.time()
	duration = end - start
	print("Parallel using Map:\t\t", results[:10],int(1000*duration),"ms")
	#input()
	return

def showStarmap(N):
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = pool.starmap(exponent, [(x,)for x in N])
	pool.close() 
	end = time.time()
	duration = end - start
	print("Parallel using Starmap:\t\t", results[:10],int(1000*duration),"ms")
	#input()
	return

async_results = []
def collect_result(result):
    global async_results
    async_results.append(result)

def showApply_async(N):
	#results = []
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	for x in N:
		pool.apply_async(exponent, args=(x,), callback=collect_result)
	pool.close()
	pool.join()
	results = [r for r in async_results]
	#print(async_results)
	end = time.time()
	duration = end - start
	print("Parallel using Apply_async:\t", async_results[:10],int(1000*duration),"ms")
	#input()
	return

def showMap_async(N):
	start = time.time()
	pool = mp.Pool(mp.cpu_count())
	results = pool.map_async(exponent, [x for x in N]).get()
	pool.close() 
	end = time.time()
	duration = end - start
	print("Parallel using Map_async:\t", results[:10],int(1000*duration),"ms")
	#input()
	return

def main():
	naturalNumbers = [x for x in range(1,10)]
	showSeq(naturalNumbers)
	showApply(naturalNumbers)
	showMap(naturalNumbers)
	showStarmap(naturalNumbers)
	showApply_async(naturalNumbers)
	showMap_async(naturalNumbers)

if __name__ == '__main__':
	main()
	input() 