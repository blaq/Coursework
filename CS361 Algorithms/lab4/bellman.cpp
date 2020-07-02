#include <bits/stdc++.h>

using namespace std;

struct Edge{    int src, dest, weight;	};
 
struct Graph{	int V, E;
		struct Edge* edge;	};
 
struct Graph* createGraph( int V, int E )
{
	struct Graph* graph = new Graph;
	graph->V = V;
	graph->E = E;
	graph->edge = new Edge[E];
	return graph;
}
 
void printStep( int dist[], int n )
{
	for (int i = 0; i < n; ++i)
	{
		if (dist[i] != INT_MAX)
			cout << "  " <<  dist[i];
		else
			cout << "  " << "-";
	}
	
	cout << '\n';

}
 
void BellmanFord( struct Graph* graph, int src )
{
	int V, E, i, j, u, v, weight;

	V = graph->V;
	E = graph->E;
	int dist[V];

	for(i = 0; i < V; ++i)
		cout << "  " << (char)(i+65);
	cout << '\n';
 
	for (i = 0; i < V; i++)
		dist[i] = INT_MAX;
	dist[src] = 0;
	printStep( dist, V );

	for (i = 1; i <= V-1; i++)
	{
		for (j = 0; j < E; j++)
		{
			u = graph->edge[j].src;
			v = graph->edge[j].dest;
			weight = graph->edge[j].weight;
			
			if ((dist[u] != INT_MAX) && (dist[u] + weight < dist[v]))
			{	dist[v] = dist[u] + weight;
				printStep( dist, V );
			}
		}
	}

	for (i = 0; i < E; i++)
	{
		u = graph->edge[i].src;
		v = graph->edge[i].dest;
		weight = graph->edge[i].weight;
		
		if ((dist[u] != INT_MAX) && (dist[u] + weight < dist[v]))
			printf("Error: negative weight cycle");
	}
 
	return;
}

Graph* addEdge( Graph* graph, int n, char u, char v, int w )
{
	int c = 65;
	int a = u - c;
	int b = v - c;

	graph->edge[n].src = a;
	graph->edge[n].dest = b;
	graph->edge[n].weight = w;
	
	return graph;
}

int main()
{
	int V = 14; 
	int E = 21;
	struct Graph* g = createGraph(V, E);
    
	int i = 0;	

	g = addEdge( g, i, 'A', 'B', -2 );
	g = addEdge( g, ++i, 'A', 'D', 3 );
	g = addEdge( g, ++i, 'B', 'C', 1 );
	g = addEdge( g, ++i, 'C', 'M', 3 );
	g = addEdge( g, ++i, 'C', 'N', -3 );
	g = addEdge( g, ++i, 'D', 'E', 2 );
	g = addEdge( g, ++i, 'D', 'F', 6 );
	g = addEdge( g, ++i, 'D', 'G', -1 );
	g = addEdge( g, ++i, 'D', 'N', -1 );
	g = addEdge( g, ++i, 'E', 'F', 3 );
	g = addEdge( g, ++i, 'F', 'H', -2 );
	g = addEdge( g, ++i, 'G', 'H', 1 );
	g = addEdge( g, ++i, 'G', 'J', 3 );
	g = addEdge( g, ++i, 'H', 'I', -4 );
	g = addEdge( g, ++i, 'H', 'K', -1 );
	g = addEdge( g, ++i, 'I', 'J', 2 );
	g = addEdge( g, ++i, 'J', 'K', 3 );
	g = addEdge( g, ++i, 'J', 'N', 5 );
	g = addEdge( g, ++i, 'K', 'L', 2 );
	g = addEdge( g, ++i, 'L', 'M', -4 );
	g = addEdge( g, ++i, 'M', 'N', 8 );

	BellmanFord(g, 0);
 
	cout << '\n';
	return 0;
}
