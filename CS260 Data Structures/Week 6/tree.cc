#include <stdio.h>
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

struct Node { int id;
                Node *left;
                Node *right;  } *temp,*tree;

Node *add(Node *tree,int input)
{
  if(tree==NULL)
  {
    tree = new Node;
    tree->left = tree->right = NULL;
    tree->id = input;
  }
  else if(input<=tree->id)
    tree->left=add(tree->left,input);
  else
    tree->right=add(tree->right,input);
  return tree;
}

Node *sub(Node *tree,int input)
{
  if(tree==NULL)
    return tree;
  else if(input < tree->id)
    tree->left = sub(tree->left,input);
  else if(input > tree->id)
    tree->right = sub(tree->right,input);
  else
  {
    //no children
    if(tree->left == NULL && tree->right == NULL)
    {
      delete tree;
      tree = NULL;
    }
    //one child: left
    else if(tree->right == NULL)
    {
      Node *temp = tree;
      tree = tree->left;
      delete temp;
    }
    //one child: right, or two children
    else
    {
      Node *temp = tree;
      tree = tree->right;
      delete temp;
    }
  }
  return tree;
}
void preOrder(Node *tree)
{
     if(tree!=NULL)
     {
          cout << " " << tree->id;
          preOrder(tree->left);
          preOrder(tree->right);
     }
}

void inOrder(Node *tree)
{
     if(tree!=NULL)
     {
          inOrder(tree->left);
          cout << " " << tree->id;
          inOrder(tree->right);
     }
}

void postOrder(Node *tree)
{
     if(tree!=NULL)
     {
          postOrder(tree->left);
          postOrder(tree->right);
          cout << " " << tree->id;
     }
}

int main()
{
  int choice = 1,input;
  Node *tree=NULL;

  while( choice )
  {
    cout << "\n [1 to ADD]\n";
    cout << " [2 to REMOVE]\n";
    cout << " [3 to TRAVERSE]\n";
    cout << " [0 to QUIT]\n>";

    cin >> choice;

    switch( choice )
    {
      case 0:
        break;
      case 1:
        cout << " Node ID:\n>";
        cin >> input;
        tree=add(tree,input);
        cout << " Node inserted\n";
        break;
      case 2:
        cout << " Node ID:\n>";
        cin >> input;
        tree=sub(tree,input);
        cout << " Node removed\n";
        break;
      case 3:
        cout << " [1-Pre-order]\n";
        cout << " [2-Post-order]\n";
        cout << " [3-In-order]\n>";
        cin >> input;
        switch(input)
        {
          case 1:
            cout << "  (";
            preOrder(tree);
            cout << " )\n";
            break;
          case 2:
            cout << "  (";
            postOrder(tree);
            cout << " )\n";
            break;
          case 3:
            cout << "  (";
            inOrder(tree);
            cout << " )\n";
            break;
          default :
            cout << " ^invalid\n";
        }
        break;
      default :
        cout << " ^invalid\n";
    }
  }
  return 0;
}
