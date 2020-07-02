#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>
#include <vector>
#include <algorithm>
#include <ctime>

using namespace std;

int unSorted[100000000];	// Control array
int ms[100000000];		// Copy of control array to be merge-sorted
int qs[100000000];		// Copy of control array to be quick-sorted
int rs[100000000];		// Copy of control array to be radix-sorted
int bs[100000000];		// Copy of control array to be bin-sorted
int utility[100000000];



void auxBinSort( float arr[], int n )
{
	vector<float> b[n];

	for( int i = 0; i < n; i++ )
	{
		int bi = n*arr[i];
		b[bi].push_back(arr[i]);
	}

	for( int i = 0; i < n; i++ )
		sort(b[i].begin(), b[i].end());

	int index = 0;
	for( int i = 0; i < n; i++ )
		for( int j = 0; j < b[i].size(); j++ )
			arr[index++] = b[i][j];
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
//-------------------------------------------------------------------------
// Job 2
// Calls the BinSort function.

float a[] = {3,200,1,6,5,4,7,8,100};
int n = sizeof(a)/sizeof(a[0]);
	auxBinSort( a, n );
	
	cout << "\nBinSort Array--";
//	printResults( bs, exTime, size );
	
	for( int h=0; h<n;h++)
		cout << bs[h] << "/";


//--------------------------------------------------------------------------

	return 0;
}

