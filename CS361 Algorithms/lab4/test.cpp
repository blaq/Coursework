#include <stdlib.h>
#include <iostream>
#include <string>

using namespace::std;

struct Q { string name, a, b; } s, q1, q2, r1, r2;

string dfa( string n, string input, int i )
{
	struct Q state = n;

	cout << "-> " << state.name;

	if( i < input.length () )
	{		
		if( input.at(i) == 'a' )
			return dfa( state.a, input, ++i );
		else if( input.at(i) == 'b' )
			return dfa( state.b, input, ++i );
		else
			return "err";
	}
	else
		return state.name;
}

int main()
{
	s = { "s", "q1", "r1" };
	q1 = { "q1", "q1", "q2" };
	q2 = { "q2", "q1", "q2" };
	r1 = { "r1", "r2", "r1" };
	r2 = { "r2", "r2", "r1" };

	string input[] = { "ababa", "baba q1", "aababaab", "babaabaaabb", "" };
	string result;

	for( int i = 0; i < 5; i++ )
	{
		result = dfa( s.name, input[i], 0 );
		
		if( result == "err" )
			cout << "\n\"" << input[i] << "\" is not a valid string\n\n";
		else if( (result == "q1") || (result == "r1") )
			cout << '\n' << input[i] << " : accepted\n\n";
		else
			cout << '\n' << input[i] << " : rejected\n\n";
	}

	return 1;
}
