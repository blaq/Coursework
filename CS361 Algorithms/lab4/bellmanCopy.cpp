#include <stdlib.h>
#include <iostream>
#include <list>
#include <vector>

using namespace::std;

void addEdge( vector <pair<int, int> > adj[], char u, char v, int wt )
{
	int c = 65;
	int a = u - c;
	int b = v - c;

	adj[a].push_back( make_pair( b, wt ) );
	adj[b].push_back( make_pair( a, wt ) );
}

int main()
{
	int V = 14;
	vector<pair<int, int > > adj[V];

	addEdge( adj, 'A', 'B', -2 );
	addEdge( adj, 'A', 'D', 3 );
	addEdge( adj, 'B', 'C', 1 );
	addEdge( adj, 'C', 'M', 3 );
	addEdge( adj, 'C', 'N', -3 );
	addEdge( adj, 'D', 'E', 2 );
	addEdge( adj, 'D', 'F', 6 );
	addEdge( adj, 'D', 'G', -1 );
	addEdge( adj, 'D', 'N', -1 );
	addEdge( adj, 'E', 'F', 3 );
	addEdge( adj, 'F', 'H', -2 );
	addEdge( adj, 'G', 'H', 1 );
	addEdge( adj, 'G', 'J', 3 );
	addEdge( adj, 'H', 'I', -4 );
	addEdge( adj, 'H', 'K', -1 );
	addEdge( adj, 'I', 'J', 2 );
	addEdge( adj, 'J', 'K', 3 );
	addEdge( adj, 'J', 'N', 5 );
	addEdge( adj, 'K', 'L', 2 );
	addEdge( adj, 'L', 'M', -4 );
	addEdge( adj, 'M', 'N', 8 );


	cout << '\n';
	return 1;
}
