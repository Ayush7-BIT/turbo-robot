#include<bits/stdc++.h>
using namespace std;
class Tree
{
public:
  int data;
  Tree *left = NULL, *right = NULL;
  // Constructor initialised
    Tree (int x)
  {
    data = x;
    left = NULL;
    right = NULL;
  }
};

int search (Tree * root, int value)
{
  while (root != NULL)
    {
      if (value > root->data)
	root = root->right;

      else if (value < root->data)
	root = root->left;

      else
	return 1;
    }

  return 0;
}

void inorder_traversal (Tree * root)
{
  if (root == NULL)
    return;
  inorder_traversal (root->left);

  cout << root->data << " ";

  inorder_traversal (root->right);

}

int main ()
{
  Tree *root = new Tree (15);
  root->left = new Tree (13);
  root->right = new Tree (18);
  root->left->left = new Tree (8);
  root->left->right = new Tree (14);
  root->right->left = new Tree (16);
  root->right->right = new Tree (19);
  
  cout << "Inorder Traversal of the Binary Search Tree:";
  inorder_traversal (root);
  
  cout << endl;
  cout<< "Searching for element 15 \n";
  cout <<"Element found? : "<< search (root, 15);

}
