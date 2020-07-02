#include <iostream>
#include <stdio.h>
#include <ctype.h>
#include "bag.h"

using namespace std;

int main()
{
  char input = 'm';

  cout << "[Press m for marble]" << endl;

  while(input == 'm')
  {
    cin >> input;
    input = tolower(input);
    bag();
  }
  return 0;
}
