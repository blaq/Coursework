#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <ctime>

using namespace std;

int unSorted[100000000];	// Control array
int rs[100000000];		// Copy of control array to be radix-sorted
int output[10000000];

int getMax( int array[], int size)
{
	int max = array[0];
	
	for( int i = 1; i < size; i++ )
		if( array[i] > max )
			max = array[i];
	
	return max;
}

void countSort( int array[], int size, int radix )
{
	int count[10] = { 0 };
	int i;

	for( i = 0; i < size; i++ )
		count[ (array[i]/radix)%10 ]++;

	for( i = 1; i < 10; i++ )
		count[i] += count[i-1];

	for( i = size-1; i >= 0; i-- )
	{
		output[ (count[ (array[i]/radix)%10 ]-1) ] = array[i];
		count[ (array[i]/radix)%10 ]--;
	}
	
	for( i = 0; i < size; i++ )
		array[i] = output[i];
cout << "<0>";
}

void auxRadixSort( int array[], int size )
{
	int max = getMax( array, size );
	
	for( int radix = 1; max/radix > 0; radix *= 10)
	{
		cout << "+" << max/radix << "+";
		countSort( array, size, radix );
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
	int j, q, size, milliseconds;
	clock_t start, stop;
	double exTime;

	
	file = fopen("lab3_data.txt", "r");	// source of integers
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

		unSorted[size] = rs[size] = atoi(str);
		
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

/*	cout << "\nOriginal Array-";
	printResults( unSorted, exTime, size );
*/
//--------------------------------------------------------------------------
// Job 1
// Calls the Radixsort function.
	auxRadixSort( rs, size );

	cout << "\nRadixSort Array";
	printResults( rs, exTime, size );

//--------------------------------------------------------------------------
// Job 4
// Calls the Mergesort function. Sends an exclusive copy of the array of 
// integers, a start index and, end index.
// Execution time is being recorded to 'mergeExTime'.
/*
	start = clock();

	auxMergeSort( ms, 0, size-1 );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nMergeSort Array";
	printResults( ms, exTime, size );
*/
//--------------------------------------------------------------------------
// Job 4
// Calls the Quicksort function. Sends and exclusive copy of the array of 
// integers, a start index, and end index.
// Execution time is being recorded to 'quickExTime'.
/*
	start = clock();

	auxQuickSort( qs, 0, size-1 );

	stop = clock();
	exTime = ((stop-start)/(double)CLOCKS_PER_SEC)*milliseconds;

	cout << "\nQuickSort Array";
	printResults( qs, exTime, size );
*/
//--------------------------------------------------------------------------

	return 0;
}

