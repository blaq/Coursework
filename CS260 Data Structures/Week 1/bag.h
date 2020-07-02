#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

struct marble{  string color;
                string size;   };

struct marble determiner(marble current)
{
  string color_key[5] = { "red", "green", "yellow", "blue", "violet" };
  string size_key[3] = { "small", "average", "big"};

  //int r_one = rand() % 5;
  //int r_two = rand() % 3;

  //current.color = color_key[r_one];
  //current.size = size_key[r_two];

  return current;
}

int bag()
{
  struct marble current;

  current = determiner(current);

  cout << "This marble is " << current.color << " and " << current.size << "." << endl;

  return 0;
}
