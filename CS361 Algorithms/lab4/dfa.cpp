#include <stdlib.h>
#include <iostream>
#include <string>

using namespace::std;

string s( string, int );
string q1( string, int );
string q2( string, int );
string r1( string, int );
string r2( string, int );

string s( string input, int i )
{
	cout << "-> s ";

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return q1( input, ++i );
		else if( input.at(i) == 'b' )
			return r1( input, ++i );
		else
			return "err";
	}
	else
		return "s";
}

string q1( string input, int i )
{
	cout << "-> q1 ";

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return q1( input, ++i );
		else if( input.at(i) == 'b' )
			return q2( input, ++i );
		else
			return "err";
	}
	else 
		return "q1";
}

string q2( string input, int i )
{
	cout << "-> q2 ";

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return q1( input, ++i );
		else if( input.at(i) == 'b' )
			return q2( input, ++i );
		else
			return "err";
	}
	else
		return "q2";
}

string r1( string input, int i )
{
	cout << "-> r1 ";

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return r2( input, ++i );
		else if( input.at(i) == 'b' )
			return r1( input, ++i );
		else
			return "err";
	}
	else
		return "r1";
}

string r2( string input, int i )
{
	cout << "-> r2 ";

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return r2( input, ++i );
		else if( input.at(i) == 'b' )
			return r1( input, ++i );
		else
			return "err";
	}
	else
		return "r2";
}

int main()
{
	string input[] = { "ababa", "baba q1", "aababaab", "babaabaaabb", "" };
	string result;

	for( int i = 0; i < 5; i++ )
	{
		result = s( input[i], 0 );
		
		if( result == "err" )
			cout << "\n\"" << input[i] << "\" is not a valid string\n\n";
		else if( (result == "q1") || (result == "r1") )
			cout << '\n' << input[i] << " : accepted\n\n";
		else
			cout << '\n' << input[i] << " : rejected\n\n";
	}

	return 1;
}
