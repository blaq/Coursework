#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <ctime>
#include <cmath>

using namespace std;

int unSorted[100000000];	// Control array
int ms[100000000];		// Copy of control array to be merge-sorted
int qs[100000000];		// Copy of control array to be quick-sorted
int rs[100000000];		// Copy of control array to be radix-sorted
int bs[100000000];		// Copy of control array to be bin-sorted
int utility[100000000];

int getMax( int array[], int size)
{
//--------------------------------------------------------------------------
// Job 1 
// RadixSort support function

	int max = array[0];			// Starts at the beginning 
						// of the array.
	for( int i = 1; i < size; i++ )		// Checks every element till
		if( array[i] > max )		// it finds the biggest int.
			max = array[i];
	
	return max;	// Returns biggest int

//--------------------------------------------------------------------------
}

void countSort( int array[], int size, int radix )
{
//--------------------------------------------------------------------------
// Job 1
// RadixSort support function

	int count[10] = { 0 };	// Each digit will be a value from 0-9
	int i;

	for( i = 0; i < size; i++ )
		count[ (array[i]/radix)%10 ]++; // Put the count array at 
						// location that the input
						// array's element is equal
						// to that index of count[]

	for( i = 1; i < 10; i++ )
		count[i] += count[i-1];	// Increment all index val of count
					// by all index val that come befor
					// them in count

	for( i = size-1; i >= 0; i-- )
	{
		utility[ (count[ (array[i]/radix)%10 ]-1) ] = array[i];
			// Fill utility array with values from the input 
			// array in the order that they were placed in
			// the count array

		count[ (array[i]/radix)%10 ]--;	// Decrement count array
						// since the element was 
						// moved to utility[]
	}
	
	for( i = 0; i < size; i++ )
		array[i] = utility[i];	// Fill the input array with the
					// elements of the utility array

//--------------------------------------------------------------------------
}

void auxRadixSort( int array[], int size )
{
//--------------------------------------------------------------------------
// Job 1
// RadixSort main function
// Compares each 10s place of an integer to sort the array

	int max = getMax( array, size );	// Gets the biggest int
						// in array.
	
	for( int radix = 1; max/radix > 0; radix *= 10)
		countSort( array, size, radix );

	// For every digit, starting with the largest, the countSort 
	// function will be call to to sort the elements base on that 
	// digit's value.

//--------------------------------------------------------------------------
}

void auxBinSort( int array[], int size, int q )
{
//--------------------------------------------------------------------------
// Job 2
// BinSort main funciton
// Places ints in similar buckets then sorts them in their buckets

	int i, j, k;

	for( i = 0; i < size; ++i )
		utility[i] = 0;		// Fill utility array with 0

	for( i = 0; i < size; ++i )
		++utility[array[i]];	// Increment the utility array 
					// elements at the location of the
					// input array's element value

	for( i = 0, j = 0; j < q; ++j )
		for( k = utility[j]; k > 0; --k )
			array[i++] = j;
			
			// For as many ints as we have, set k = each bucket
			// then assign the val of the current location to
			// the input arrays ascending location.

//--------------------------------------------------------------------------
}

void merge( int array[], int startIndex, int pivot, int endIndex )
{
//--------------------------------------------------------------------------
// Job 4
// MergeSort support function

	int i, j, k;
	int *tmp = new int[endIndex - startIndex + 1];	// Utility array
	

	i = startIndex;
	j = pivot + 1;
	k = 0;

	while( (i <= pivot) && (j <= endIndex) )
	{					// Puts elements in utility
		if( array[i] <= array[j] )	// array either, 
		{
			tmp[k] = array[i];	// before if less than the 
			i++;			// pivot,
		}
		else
		{
			tmp[k] = array[j];	// or after if greater than
			j++;			// the pivot.
		}

		k++;			// k keeps track of where we put 
					// elements into the utility array
	}

	while( i <= pivot )		// We haven't filled the utility
	{				// array yet, so we will put all the
		tmp[k] = array[i];	// elements less than pivot in their
		i++;			// respective spaces and keep 
		k++;			// incrementing till we reach the 
	}				// pivot.

	while( j <= endIndex )		// We then do the same thing with
	{				// the elements greater than the 
		tmp[k] = array[j];	// pivot
		j++;
		k++;
	}

	for( i = 0; i < k; i++ )		// Fill original array with
		array[startIndex + i] = tmp[i];	// contents of the sorted
						// utility array.

	delete[] tmp;	// Delete the pointer to the Utility array and free
	tmp = NULL;	// up space.

//--------------------------------------------------------------------------
}


void auxMergeSort( int array[], int startIndex, int endIndex )
{
//--------------------------------------------------------------------------
// Job 4
// MergeSort main function
// Splits an array into to half sized arrays with every recursive call until
// The array is size 1 or 0.

        if( startIndex < endIndex )
	{
		int pivot = startIndex + ( endIndex - startIndex ) / 2 ;
						// Find the midpoint of array
		
		auxMergeSort( array, startIndex, pivot );
						// Recursive call with first
						// half of array

		auxMergeSort( array, pivot+1, endIndex );
						// Same with the second half

		merge( array, startIndex, pivot, endIndex );
						// Calls the function that 
						// merge separated arrays
	}

//--------------------------------------------------------------------------
}


int partition( int array[], int startIndex, int endIndex )
{
//--------------------------------------------------------------------------
// Job 4
// QuickSort support function
// Finds and returns the midpoint of the array given.

	int swap;			// utility variable
	int pivot = array[endIndex];	// last element location as pivot
	int i =	startIndex - 1;		// 1 less than first element location

	for( int j = startIndex; j < endIndex; j++ )
	{				// Runs through every 
					// element in given array

		if( array[j] <= pivot )		// compares element to pivot
		{
			i++;			// if element is less than
			swap = array[i];	// pivot, then element at i
			array[i] = array[j];	// is swapped with current
			array[j] = swap;	// element.
		}
	}

	swap = array[i+1];		// Pivot separates all elements into
	array[i+1] = array[endIndex];	// both sides, either less than or
	array[endIndex] = swap;		// greater, and then is put in the 
					// middle, which is after i.

	return (i+1);		// Returns the pivot

//--------------------------------------------------------------------------
}


void auxQuickSort( int array[], int startIndex, int endIndex )
{
//--------------------------------------------------------------------------
// Job 4
// Quicksort main function
// Receives the array, locations for the first and last element. Will 
// recursively call itself, shrinking every call, until the first elements
// location is no longer smaller than the last element's location.

	int pivot;

	if( startIndex < endIndex )	// Only sorts if the integers are 
	{				// out of order. This will also be
					// the base case for exiting the 
					// recursive loop

		pivot = partition( array, startIndex, endIndex );
					// Calls partition function to find
					// the midpoint of the array.

		auxQuickSort( array, startIndex, pivot-1 );
					// Recursive call this fuinction but
					// only for the first half of the 
					// array.

		auxQuickSort( array, pivot+1, endIndex );
					// Same as above but for the second
					// half.	
	}

//--------------------------------------------------------------------------
}

void findLargest( int array[], int size, int count )
{
	int i;

	count--;

	if( count == 0 )
	{	
		for( i = 0; i < size; i++ )
		{
			if( utility[count] < array[i] )
			{
				utility[count] = array[i];
			}
		}		
	}
	else if( count > 0 )
	{
		findLargest( array, size, count );
		
		for( i = 0; i < size; i++ )
		{
			if( (utility[count] < array[i]) && (array[i] < utility[count-1]) )
			{
				utility[count] = array[i];
			}
		}
	}
}

int flgIsSorted( int array[], int size )
{
//--------------------------------------------------------------------------
// Job 3
// Recieves an array and the size of the array.

	if( size < 500 )	// this ends the recursive calling process
		return 1;	// if it is checking the last 500 integers
				// and will return a '1', confirming sort.

	for( int e = 0; e < 500; e++ )	// checks 500 increments of array
	{
		 if( array[(size-e)-1] < array[(size-e)-2] )
			return 0;		
					// checks if prior integer is larger
					// than the current integer. If the
					// integer is smaller than the one
					// before, the function will return
					// a '0', confirming that array is
					// unsorted. 						
	}

	return flgIsSorted( array, (size-500) );
		
		// if the size is not the last 500 integer increment, then
		// this function is called with size of 500 less integers.
		// This will recursively be called until the last 500 is 
		// reached or the comparison check throws a '0'.

//--------------------------------------------------------------------------
}


void printResults( int array[], double exTime, int size )
{
//--------------------------------------------------------------------------
// Variable declarations

	int j, milliseconds, checkSort;
	double checkTime;
	unsigned long int sum;
	clock_t start, stop;
	
	milliseconds = 1000;
	sum = 0;

	for( j = 0; j < size; j++ )	// counts sum of array
		sum = sum + array[j];	// verifies that the array is being 
					// filled correctly

//--------------------------------------------------------------------------
// Job 3
// calls the 'flgIsSorted' function to test if given array is sorted. It 
// will return a '1' if so and a '0' if not.
// Execution time is being recorded to 'checkTime'.

	start = clock();

	checkSort = flgIsSorted( array, size );

	stop = clock();
	checkTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

//--------------------------------------------------------------------------
// Print operations
// The code here looks real gross but the terminal output is on point
	
	for( int e = 0; e < 42; e++ )
		cout << "-";
	
	cout << "\n|\t\t\t\t\t\t\t|\n|\tSum: " << sum << "\tSorted:\t";

	if( checkSort == 1 )
		cout << "True\t\t|\n|\t\t\t\t\t\t\t|";
	else
		cout << "False\t\t|\n|\t\t\t\t\t\t\t|";
	
	cout << "\n|\tFirst 3 elements\tLast 3 Elements\t\t|\n|";
	for( int e = 0; e < 3; e++)
		cout << "\t\t" << array[e] << "\t\t    " << array[(size-e)-1] << "\t\t|\n|";

	cout << "\t\t\t\t\t\t\t|\n|\tExecution time (ms)\tflgIsSorted time (ms)\t|\n"; 

	cout << "|\t\t" << exTime << "\t\t    " << checkTime << "\t\t|\n|\t\t\t\t\t\t\t|\n";
	
	for( int e = 0; e < 57; e++ )
		cout << "-";
	
	cout << "\n";

//--------------------------------------------------------------------------
}


int main()
{
//--------------------------------------------------------------------------
// Variable declarations

	FILE *file;
	char str[10];
	int j, q, num, size, milliseconds;
	clock_t start, stop;
	double exTime;

	
	file = fopen("lab3_data.txt", "r");	// source of integers
	num = 10;
	size  = 0;					// indexing variable
	q = 10000000;				// amount of intgers
	milliseconds = 1000;			// seconds to milliseconds
						// converter
		
//--------------------------------------------------------------------------
// A 10 char string is taken from every line of the file and coverted to an 
// integer. Each integer put in the same location of 3 different arrays to 
// be sorted. 
// Execution time is being recorderded to 'originalExTime'.

	start = clock();   // starts timer

	while( (size < q) && (fgets( str, 10, file ) != NULL) )
	{			// Puts the current line into a sting and
				// will loop until the array is filled or the
				// all ints in the file have been read

		unSorted[size] = atoi(str);
		rs[size] = bs[size] = ms[size] = qs[size] = unSorted[size];
						// Converts the string to an
						// an int and then puts into 
						// every array.	

		size++;		// Tracks how many ints are in the array
	}


	stop = clock();   // stops timer
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;
					// (stop-start) clock ticks
					// divided by clock ticks per second
					// put into units of milliseconds

	fclose( file );

//	cout << "\nOriginal Array-";
//	printResults( unSorted, exTime, size );

//--------------------------------------------------------------------------
// Job 1
// Calls the Radixsort function.
/*
	start = clock();

	auxRadixSort( rs, size );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nRadixSort Array";
	printResults( rs, exTime, size );


//-------------------------------------------------------------------------
// Job 2
// Calls the BinSort function.

	start = clock();

	auxBinSort( bs, size, q );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;
	
	cout << "\nBinSort Array--";
	printResults( bs, exTime, size );
	
//--------------------------------------------------------------------------
// Job 4
// Calls the Mergesort function. Sends an exclusive copy of the array of 
// integers, a start index and, end index.
// Execution time is being recorded to 'mergeExTime'.

	start = clock();

	auxMergeSort( ms, 0, size-1 );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nMergeSort Array";
	printResults( ms, exTime, size );

//--------------------------------------------------------------------------
// Job 4
// Calls the Quicksort function. Sends and exclusive copy of the array of 
// integers, a start index, and end index.
// Execution time is being recorded to 'quickExTime'.

	start = clock();

	auxQuickSort( qs, 0, size-1 );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nQuickSort Array";
	printResults( qs, exTime, size );
*/
//--------------------------------------------------------------------------
// Job 6
// Finds the 10 largests ints in my unsorted array by calling the 
// findLargest function. Execution is timed and results are printed here.
for( int p = 0; p<5; p++){
for( int j=0;j<3;j++){
int fuckyou = q/pow(10,p);
	cout << "\nints\t"<< fuckyou;

	start = clock();

	findLargest( unSorted, fuckyou, num );


	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nExecution Time:\t" << exTime << "ms";

//--------------------------------------------------------------------------
// Job 7
// Sorts the 10 largest arrays with merge sorts and outputs them in 
// descending order.

	start = clock();

	auxMergeSort( utility, 0, num-1 );

	cout << "\n\nSorted:\t\t";

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nExecution Time:\t" << exTime << "ms\n";
}}
//--------------------------------------------------------------------------
	return 0;
}

