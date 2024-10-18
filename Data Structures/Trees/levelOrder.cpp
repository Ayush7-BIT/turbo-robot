#include <bits/stdc++.h>
using namespace std;

/* cpp code that performs level order traversal on a binary tree */
/* Demo:
        1
       / \
      2   3
     / \ / \
    4  5 6  7

    Level order traversal: 1 2 3 4 5 6 7
*/

struct TreeNode
{
    int data;
    TreeNode *left;
    TreeNode *right;

    // constructor
    TreeNode();
    TreeNode(int x) : data(x), left(nullptr), right(nullptr) {}
};

void levelOrder(TreeNode *root)
{
    vector<vector<int>> lvlorder;
    queue<TreeNode *> q;
    if (!root)
        return;

    q.push(root);
    while (!q.empty())
    {
        int size = q.size();
        vector<int> lvl;
        for (int i = 0; i < size; i++)
        {
            TreeNode *node = q.front();
            q.pop();

            // pushing left and right child to queue
            if (node->left)
                q.push(node->left);

            if (node->right)
                q.push(node->right);

            lvl.push_back(node->data);
        }
        lvlorder.push_back(lvl);
    }

    for (vector<int> v : lvlorder)
    {
        for (int i : v)
        {
            cout << i << " ";
        }
    }
}

int main()
{
    TreeNode *root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

    cout << "Level order traversal: ";
    levelOrder(root);

    return 0;
}