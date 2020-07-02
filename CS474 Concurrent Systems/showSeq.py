import multiprocessing as mp
import time

def exponent(x):
	return x*x

def showMap_async(N):

	pool = mp.Pool(mp.cpu_count())

	# we use .get() to get results. 
	# if we don't the program will continue without the results
	#results = pool.map_async(exponent, [x for x in N]).get()
	results = pool.starmap_async(exponent, [(x,) for x in N]).get()



	pool.close() 

	print("Parallel using Map_async:\t", results)
	return

def main():
	# creates list of the first 10 Natural NUmbers
	naturalNumbers = [x for x in range(1,11)]
	
	showMap_async(naturalNumbers)

if __name__ == '__main__':
	main()


	input() 

