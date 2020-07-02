#include <stdlib.h>
#include <iostream>
#include <limits.h>

using namespace::std;

class DynamicProgramming
{
  public:
	
	int brackets[7][7];

	int matrixChain( int array[], int size )
	{
		int matrix[size][size];
		int i, j, k, l, q, result;
		char name;

		for( i = 1; i < size; i++ )
			matrix[i][i] = 0;

		for( l = 2; l < size; l++ )
		{
			for( i = 1; i < (size-l)+1; i++ )
			{
				j = (i+l)-1;
				matrix[i][j] = INT_MAX;
			
				for( k = i; k <= (j-1); k++ )
				{
					q = matrix[i][k] + matrix[k+1][j] + array[i-1]*array[k]*array[j];
					if( q < matrix[i][j] )
					{
						matrix[i][j] = q;
						brackets[i][j] = k;
					}

				}
				//cout << "m[" << i << "," << j << "] = " << q << "\tk=" << k << endl;
			}
		}

		result = matrix[1][size-1];

		name = 'A';
		paranthesis( 1, size-1, name );

		return matrix[1][size-1];
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
};

class Memoization
{
  public:

//	MatrixChainMult MCM;
	int brackets[7][7];

	int matrix[7][7];

	int matrixChain( int array[], int size )
	{
		int i, j, result;
		char name;

		for( i = 1; i < size+1; i++ )
		{
			for( j = 1; j < size+1; j++ )
				matrix[i][j] = -1;
		}
		
		result = records( array, 1, size );
		
		name = 'A';	
		paranthesis( 1, size, name );

		return result;
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
};

int main()
{
	int array[] = { 30, 4, 8, 5, 10, 25, 15 };
	int size = sizeof(array)/sizeof(array[0]);

	int matrix;
	DynamicProgramming DP;
	Memoization Memo;

	matrix = DP.matrixChain( array, size );

	cout << ": " << matrix << endl;

	matrix = Memo.matrixChain( array, size-1 );
	
	cout << ": " << matrix << endl;

/*	for(int i=1;i<size;i++)
	{
		for(int e=1;e<size;e++)
			cout << " " << Memo.matrix[i][e] << " ";
		cout << "\n\n";
	}
*/
	return 1;
}
