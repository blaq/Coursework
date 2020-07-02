#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

struct AdjListNode {  int dest;
                      int weight;
                      struct AdjListNode* next; };

struct AdjList {  struct AdjListNode *head; };

class Graph
{
  private:
    int V, min;
    struct AdjList *array;
  public:
    struct AdjListNode *node, *back, *curr, *forw;
    Graph( int V )
    {
      this->V = V;
      min = V*V;
      array = new AdjList [V];
      for ( int e = 0; e < V; e++ )
      {
        array[e].head = NULL;
        for( int i=0; i<V; i++ );

      }
    }

    void create( int input ) //creates randomized edges between nodes
    {
      int randomNum;
      srand( time(0) );
      for ( int e = 0; e < input*2; e++ )
      {
        randomNum = rand()%input;
        while( e/2 == randomNum )
          randomNum = rand()%input;
        addEdge( e/2, randomNum );
      }
    }

    int check( int src, int dest ) //check if nodes are the same
    {
      AdjListNode* trace;
      trace = array[dest].head;
      while( trace )
      {
        if( trace->dest == dest )
        {
          return 0;
        }
        if( trace->dest == src )
        {
          return 0;
        }
        trace = trace->next;
      }
      return 1;
    }

    AdjListNode* addNode( int dest )
    {
      AdjListNode* newNode = new AdjListNode;
      newNode->dest = dest;
      newNode->next = NULL;
      return newNode;
    }

    void addEdge( int src, int dest )
    {
      if( check( dest, src ) == 1 )
      {
        int randomNum = rand()%9+1;
        AdjListNode* newNode = addNode( dest );
        newNode->next = array[src].head;
        array[src].head = newNode;    //source node points to destination
        newNode->weight = randomNum;  //randomized weight

        newNode = addNode( src );
        newNode->next = array[dest].head;
        array[dest].head = newNode;   //destination node points to source
        newNode->weight = randomNum;  //ranndomized weight
      }
    }


    void printGraph()
    {
      int v;
      cout << "\n key: (Source node) - weight-> (destination node),\n";
      for ( v = 0; v < V; v++ )
      {
        AdjListNode* write = array[v].head;
        cout << "\n  (" << v << ") -  ";
        while( write )
        {
          cout << write->weight << "-> (" << write->dest << ")   ";
          write = write->next;
        }
      }
      cout << "\n";
    }

    void search( int a, int b )   //this is my minimum spanning tree
    {
      bool set[V];  //this array will store what nodes I have visited
      int route[V]; //this array keeps the path from point a to b
      int smallest = 10, pos, count = 0, total = 0;
      AdjListNode* trace;
      for( int o=0; o<V; o++ )
        set[o] = 0, route[o] = '\0';

      set[a] = 1;
      route[0] = a;

      while( set[b] == 0 )
      {
        for( int e=0; e<V; e++ ) //go through every node
        {
          trace = array[e].head;
          if( set[e] == 1 )   //skip nodes that have not been visited
          {
            while( (trace) && (set[b] == 0) )
            {
              if( trace->dest == b )
              {
                set[trace->dest] = 1;
                pos = trace->dest;
              }
              else if( (trace->weight  <= smallest) && (set[trace->dest] == 0) ) //find smallest edge not connected to visited nodes
              {
                pos = trace->dest;
                smallest = trace->weight;
              }
              trace = trace->next;
            }
          }
        }
        set[pos] = 1;
        route[count++] = pos;
        pos = 0;
        smallest = 10;
      }

      //print route from point a to b
      cout << " Route:  (" << a << ") ";
      for( int i=0; i<V; i++ )
      {
        if( route[i] != '\0' )
          cout << "-> (" << route[i] << ") ";
      }
      cout << "\n";
    }
  };

int main()
{
  int input, a, b, choice = 1;
  cout << " Number of nodes:\n>";
  cin >> input;

  while( input <= 1 )
    cout << " ^invalid\n>", cin >> input;

  Graph gh( input );

  cout << " Creating map now...";
  gh.create( input );
  cout << "done\n";

  while( choice )
  {
    cout << "\n [1 for MAP]\n";
    cout << " [2 to ROUTE]\n";
    cout << " [0 to QUIT]\n>";

    cin >> choice;

    switch( choice )
    {
      case 0:
        break;
      case 1:
        gh.printGraph();
        break;
      case 2:
        cout << "\n Source node:\n>";
        cin >> a;
        cout << "\n Destination node:\n>";
        cin >> b;
        gh.search( a, b );
        break;
      default :
        cout << " ^invalid\n>";
    }
  }
  return 0;
}
