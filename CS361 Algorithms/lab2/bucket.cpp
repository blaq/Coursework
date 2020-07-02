#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;
int unSorted[100000000];
int bs[100000000];
int b[100000000];

void auxBucketSort( int arr[], int n )
{int e = 0;

for (int i=0; i<n; i++)
    {
       int bi = arr[i]%11; // Index in bucket
	++b[bi];
//if( e < 10)	
	//	cout <<n<< "*"<<arr[i]<<"="<< bi <<" ";   
	//e++;    
	//b[bi].push_back(arr[i]);// here
    }
 

}

int main()
{
	FILE *file;
	char str[10];
	int j, q, size, milliseconds;
	clock_t start, stop;
	double exTime;

	
	file = fopen("lab3_data.txt", "r");
	size  = 0;
	q = 10000000;	


	while( (size < q) && (fgets( str, 10, file ) != NULL) )
	{	
		unSorted[size] = atoi(str);
		bs[size]=unSorted[size];

		size++;	
	}

	fclose( file );
   int arr[] = {0,1,9,2,8,3,7,4,6};
	auxBucketSort( arr, 9 );

 
    int n = sizeof(arr)/sizeof(arr[0]);
 
	vector <int> array;
	vector <int> :: iterator i;

	for( int i = 0; i < size; i++ )
		array.push_back(bs[i]);

	for( i = array.begin(); i != array.end(); ++i );
		//cout << *i << " ";

    cout << "Sorted array is \n";
    for (int i=0; i<n; i++)
       cout << bs[i] << " ";

	cout << '\n';
    return 0;
}
