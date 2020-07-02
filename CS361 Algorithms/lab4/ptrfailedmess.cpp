#include <stdlib.h>
#include <iostream>
#include <string>

using namespace::std;

struct Q
{
	string name;
	struct Q *a, *b;
};

Q *newState( string name, Q *a, Q *b )
{
	Q *q = new Q;	

	q->name = name;
	q->a = a;
	q->b = b;
	
	return q;
}

int main()
{
	string input;
//	char s;
	struct Q *s, *q1, *q2, *r1, *r2, *curr;
	int i;
	string accept[] = { "q1", "r1" };

/*	s = new Q;
	q1 = new Q;
	q2 = new Q;
	r1 = new Q;
	r2 = new Q;
*/
	s = newState( "s", q1, r1 );
	q1 = newState( "q1", q1, q2 );
	cout << s->name;

//	curr = s;	

	input = "ababa";

	i = 1;
	
	cout << input.at(i);

	cout << '\n';
	return 1;
}
