#include <iostream>
#include <stdio.h>
#include <ctype.h>
#include "bag.h"

using namespace std;

int main()
{
  int input, choice=1;

  while(choice)
  {
    cout << "[Press 1 to ADD]\t";
    cout << "[Press 2 to REMOVE]\t";
    cout << "[Press 0 to QUIT]\t";
    cout << "List: " << list << "\n";

    cin >> choice;

    switch(choice)
    {
      case 0:
        garbage();
        display();
        break;
      case 1:
        add();
        display();
        break;
      case 2:
        display();
        sub();
        break;
      default :
        cout << "invalid output";
    }
  }
  return 0;
}
