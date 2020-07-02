#include <iostream>
#include <stdlib.h>
#include <cmath>

using namespace::std;

int main()
{
	int selectPrimes[] = {2,3,5,7,13,17,19,31,61,89,107,127,521,607,1279,2203,2281,3217};
	int size = sizeof(selectPrimes)/sizeof(selectPrimes[0]);
	//int perfectNums[] = {6,28,496,8128,33550336,8589869056,2305843008139952128
	unsigned long long int perfectNums[size];

	for( int i = 0; i < size; i++ )
		perfectNums[i] = pow(2,selectPrimes[i]-1)*(pow(2,selectPrimes[i])-1);
	for( int e = 0; e < size; e++ )
		cout << perfectNums[e] << "\n";
	cout << '\n' << pow(10,100) << '\n';
	return 1;
}
