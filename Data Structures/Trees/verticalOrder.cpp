#include <bits/stdc++.h>
using namespace std;

/* cpp code that performs vertical order traversal on a binary tree */
/* Demo:
        1
       / \
      2   3
     / \ / \
    4  5 6  7

    vertical order traversal: 4 2 1 5 6 3 7
    Note if two nodes are at same vertical and same level, then printed in sorted order

           verticals
    -2   -1   0   +1   +2

    |    |    |    |    |
    |    |    1    |    |      <- level 0
    |    2    |    3    |      <- level 1
    4    |   5,6   |    7      <- level 2
    |    |    |    |    |      <- level 3

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

void verticalOrder(TreeNode *root)
{
    queue<pair<TreeNode *, pair<int, int>>> q;
    map<int, map<int, multiset<int>>> nodes;

    if (!root)
        return;

    q.push({root, {0, 0}});
    while (!q.empty())
    {
        auto it = q.front();
        q.pop();
        TreeNode *node = it.first;
        int vertical = it.second.first, level = it.second.second;
        nodes[vertical][level].insert(node->data);

        if (node->left)
            q.push({node->left, {vertical - 1, level + 1}});

        if (node->right)
            q.push({node->right, {vertical + 1, level + 1}});
    }

    for (auto p : nodes)
    {
        for (auto q : p.second)
        {
            for (int value : q.second)
            {
                cout << value << " ";
            }
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

    cout << "Vertical order traversal: ";
    verticalOrder(root);
}