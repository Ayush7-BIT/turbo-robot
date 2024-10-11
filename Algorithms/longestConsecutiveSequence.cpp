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
    unordered_set<int> s(v.begin(), v.end()); // for O(1) lookups
    int longest_streak = 0;

    for (int num : s)
    {
        // Check if it's the start of a sequence
        if (!s.count(num - 1))
        {
            int current_num = num;
            int current_streak = 1;

            // Keep incrementing to find the longest sequence starting with num
            while (s.count(current_num + 1))
            {
                current_num += 1;
                current_streak += 1;
            }

            longest_streak = max(longest_streak, current_streak);
        }
    }
    return longest_streak;
}

int main()
{
    vector<int> v1 = {100, 4, 200, 1, 3, 2};
    int a1 = longestConsecutiveSequence(v1);
    cout << a1 << endl;

    vector<int> v2 = {0, 1, 7, 2, 5, 8, 4, 6, 0, 1};
    int a2 = longestConsecutiveSequence(v2);
    cout << a2 << endl;

    return 0;
}
