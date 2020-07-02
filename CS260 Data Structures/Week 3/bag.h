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
  int count = 1;
  curr = beg;
  while(curr->ptr != NULL && count != pos)  //finds position to subtract from
  {
      prev = curr;
      curr = curr->ptr;
      count++;
  }
}

void add()
{
  int pos=0;
  node = new marble;

  cout << "Enter item number ";
  cin >> node->identity;

  curr = beg;
  if(beg != NULL)
  {
    cout << "Enter desired postion number ";
    cin >> pos;
    find(pos);

    if(pos == 1)  //adds node to the beginning of list
    {
       curr = beg;
       beg = node;
       beg->ptr = curr;
       list++;
    }
    else if(curr->ptr == NULL && pos == list+1) //adds node to end of list
    {
      curr->ptr = node;
      curr = node;
      curr->ptr = NULL;
      list++;
    }
    else if(pos > list+1)
      cout << " Position is out of bounds ";

    else  //adds to desired location in middle of list
    {
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
  else if(pos > list)
    cout << "Position out of bounds\n\n";
  else
  {
    if(pos == 1)  //removes beginning node
      beg = beg->ptr;
    else  //removes from any node past the beginning
    {
      find(pos);
      node = curr;
      curr = curr->ptr;
      prev->ptr = curr;
      delete node;
    }
    list--;
  }
  display();
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
