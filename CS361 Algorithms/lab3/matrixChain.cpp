#include <stdlib.h>
#include <iostream>
#include <limits.h>

using namespace::std;

int brackets[7][7];
int matrix[7][7];

int dynamic( int array[], int size );
int memoize( int array[], int size );
int records( int array[], int i, int j );
void paranthesis( int i, int j, char &name );

int dynamic( int array[], int size )
{
//	int matrix[size][size];
	int i, j, k, l, q, result;
	char name;

	for( i = 1; i < size; i++ )	// sets all m[i,i] to 0
		matrix[i][i] = 0;

	for( l = 2; l < size; l++ )	// starts for loop at m[2,1]
	{
		for( i = 1; i < (size-l)+1; i++ )	// finds precedent values
		{
			j = (i+l)-1;			
			matrix[i][j] = INT_MAX;		// current matrix value to infinity
		
			for( k = i; k <= (j-1); k++ )	// runs through each possibility
			{				// for k

				q = matrix[i][k] + matrix[k+1][j] + array[i-1]*array[k]*array[j];

						// gets the value of the select
						// matrices multiplied

				if( q < matrix[i][j] )
				{				// if it is the smallest
					matrix[i][j] = q;	// then set that value
					brackets[i][j] = k;	// to that location.
				}				// Save the k value

			}
			//cout << "m[" << i << "," << j << "] = " << q << "\tk=" << k << endl;
		}
	}

	return matrix[1][size-1];	// return the smalles value at m[6,1]
}

int memoize( int array[], int size )
{
	int i, j, result;
	char name;

	for( i = 1; i < size+1; i++ )
	{
		for( j = 1; j < size+1; j++ )
			matrix[i][j] = -1;
	}
	
	return records( array, 1, size );
}

int records( int array[], int i, int j )
{
	int k, q;

	if( matrix[i][j] != -1 )
		return matrix[i][j];
	if( i == j )
		matrix[i][j] = 0;	
	else
	{	
		if( matrix[i][j] == -1 )
			matrix[i][j] = INT_MAX;

		for( k = i; k < j; k++ )
		{
			q = records( array, i, k ) + records( array, k+1, j ) + array[i-1]*array[k]*array[j];
			if( q < matrix[i][j] )
			{
				matrix[i][j] = q; 
				brackets[i][j] = k;
			}
		}
		//cout << "[" << i << "," << j << "] = " << q << "\n";
	}

	return matrix[i][j];
}

void paranthesis( int i, int j, char &name )
{
	int k;

	if( i == j )
		cout << name++;
	else
	{
		k = brackets[i][j];

		cout << "(";

		paranthesis( i, k, name );

		paranthesis( k+1, j, name );

		cout << ")";
	}
}

int main()
{
	int array[] = { 30, 4, 8, 5, 10, 25, 15 };
	int size = sizeof(array)/sizeof(array[0]);
	int matrix;
	char name;

	name = 'A';
	matrix = dynamic( array, size );

	cout << "\n Dynamic-Programming : ";
	paranthesis( 1, size-1, name );
	cout << " = " << matrix << '\n';


	name = 'A';
	matrix = memoize( array, size-1 );	

	cout << "\n Memoization : ";
	paranthesis( 1, size-1, name );
	cout << " = " << matrix << '\n';

	cout << '\n';
	return 1;

}
