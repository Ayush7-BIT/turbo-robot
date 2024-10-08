/*
 * C++ Program to Implement Ternary Tree
 */
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include<conio.h>
using namespace std;
struct Node
{
    char data;
    unsigned isEndOfString: 1;
    struct Node *left, *eq, *right;
}*temp = NULL;
struct Node* newNode(char data)
{
    temp = new Node;
    temp->data = data;
    temp->isEndOfString = 0;
    temp->left = temp->eq = temp->right = NULL;
    return temp;
}
void insert(struct Node** root, char *word)
{
    if (!(*root))
        *root = newNode(*word);
 
    if ((*word) < (*root)->data)
        insert(&( (*root)->left ), word);
 
    else if ((*word) > (*root)->data)
        insert(&( (*root)->right ), word);
 
    else
    {
        if (*(word+1))
            insert(&( (*root)->eq ), word+1);
 
        else
            (*root)->isEndOfString = 1;
    }
}
 
void traverseTSTUtil(struct Node* root, char* buffer, int depth)
{
    if (root)
    {
        traverseTSTUtil(root->left, buffer, depth);
 
        buffer[depth] = root->data;
        if (root->isEndOfString)
        {
            buffer[depth+1] = '\0';
            cout<<buffer<<endl;
        }
 
        traverseTSTUtil(root->eq, buffer, depth + 1);
 
        traverseTSTUtil(root->right, buffer, depth);
    }
}
void traverseTST(struct Node* root)
{
    char buffer[50];
    traverseTSTUtil(root, buffer, 0);
}
 
int searchTST(struct Node *root, char *word)
{
    if (!root)
        return 0;
 
    if (*word < (root)->data)
        return searchTST(root->left, word);
 
    else if (*word > (root)->data)
        return searchTST(root->right, word);
 
    else
    {
        if (*(word+1) == '\0')
            return root->isEndOfString;
 
        return searchTST(root->eq, word+1);
    }
}
 
int main()
{
    struct Node *root = NULL;
 
    insert(&root, "cat");
    insert(&root, "cats");
    insert(&root, "up");
    insert(&root, "bug");
 
    cout<<"Following is traversal of ternary search tree\n";
    traverseTST(root);
 
    cout<<"\nFollowing are search results for cats, bu and cat respectively\n";
    searchTST(root, "cats")? cout<<"Found\n": cout<<"Not Found\n";
    searchTST(root, "bu")?   cout<<"Found\n": cout<<"Not Found\n";
    searchTST(root, "cat")?  cout<<"Found\n": cout<<"Not Found\n";
 
    getch();
}
