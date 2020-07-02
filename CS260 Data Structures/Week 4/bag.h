#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

struct marble{  int identity;
                marble *ptr;   } *node,*beg,*prev,*curr;

int list = 0;

void display()  //Link list visual
{
  curr = beg;
  cout << "Linked list is as follows\n";

  while(curr != NULL)
  {
    cout << curr->identity << " => ";
    curr = curr->ptr;
  }
  cout << "NULL\n\n";
}

void find(int pos)
{
  curr = beg;
  while(curr->ptr != NULL && curr->identity < pos)  //finds position to subtract from
  {
      prev = curr;
      curr = curr->ptr;
  }
}

void add()
{
  node = new marble;

  cout << "Enter item number ";
  cin >> node->identity;
  int pos = node->identity;

  if(beg != NULL)
  {
    find(pos);

    if(curr->ptr == NULL && pos > curr->identity) //adds node to end of list
    {
      curr->ptr = node;
      curr = node;
      curr->ptr = NULL;
      list++;
    }

    else  //adds to desired location in middle of list
    {
        if(pos <= beg->identity)
        {  prev = beg;
          curr = beg->ptr;
        }
        prev->ptr = node;
        node->ptr = curr;
        list++;
        cout << "Marble added at position: " << pos;
    }
 }
 else //creates the beginning node
 {
    beg = node;
    beg->ptr = NULL;
    list++;
    cout << "Added at beg as list is empty ";
 }
}

void sub()
{
  int pos;
  cout << "Enter the marble poition you want to remove: ";
  cin >> pos;

  if(beg == NULL)
    cout << "List is empty, therefore you cannot remove\n\n";
  else if(beg->identity == pos)
  {
    node = beg;
    beg = beg->ptr;
    delete node;
    display();
  }
  else
  {
    find(pos);
    if(curr->identity == pos)
    {
      node = curr;
      curr = curr->ptr;
      prev->ptr = curr;
      delete node;
      list--;
      display();
    }
    else
      cout << "Node not found\n";
  }

}

void garbage()
{
  while(list > 1)
  {
    find(list);
    prev->ptr = NULL;
    delete curr;
    curr = NULL;
    list--;
  }
  delete beg;
  beg = NULL;
  list--;
  cout << "Deleting list. . .";
}

void bag()
{
  int choice;

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
      cout << "invalid output\n";
  }
  bag();
}
