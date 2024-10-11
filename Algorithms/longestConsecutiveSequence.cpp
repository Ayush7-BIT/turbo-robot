#include <bits/stdc++.h>
using namespace std;

/*
Given an unsorted array of integers, write a function to find the length of the longest consecutive elements sequence.
The algorithm should run in O(n) time complexity.

Since, no constraints on space complexity is given, this solution is using O(2n) auxiliary space

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Input: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output: 9
Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8].
*/

int longestConsecutiveSequence(vector<int> v)
{
    set<int> s(v.begin(), v.end());
    vector<int> tmp(s.begin(), s.end());

    // ans counts the pairs of integers having difference 1
    int ans = 0;

    for (int i = 0; i < tmp.size() - 1; i++)
    {
        if (tmp[i + 1] - tmp[i] == 1)
            ans++;
        else
            break;
    }
    return ans + 1;
}

int main()
{
    vector<int> v1 = {100, 4, 200, 1, 3, 2};
    int a1 = longestConsecutiveSequence(v1);
    cout << a1 << endl;

    vector<int> v2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    int a2 = longestConsecutiveSequence(v2);
    cout << a2 << endl;

    return 0;
}
