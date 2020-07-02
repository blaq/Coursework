int fib( int num )
{
	if( num == 1)
		return 1;
	else:
		return fib( num -1 ) + fib( num - 2 );
}

int main()
{
	for( int i=1; i<10; i++)
		printf("%d! = %d", i, fib(i));

	return 1;
}
