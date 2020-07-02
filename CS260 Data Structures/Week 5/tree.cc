#include <stdio.h>
#include <iostream>
#include <cstdlib>
#include <string>

struct Node { int id;
                Node *left;
                Node *right;  } *node,*beg,*prev,*curr;

int list = 1;

void print(Node* node)
{
  if(node)
  {
    print(node->left);
    std::cout << node->id << " ";
    print(node->right);
  }
}

int main()
{
  beg = new Node;
  prev = new Node;
  curr = new Node;
  node = new Node;

  beg->id = 1;
  beg->left = prev;
  beg->right = curr;

  curr->id = 3;
  curr->left = NULL;
  curr->right = NULL;

  prev->id = 2;
  prev->left = NULL;
  prev->right = NULL;

  node = beg;

  print(beg);
  return 0;
}
