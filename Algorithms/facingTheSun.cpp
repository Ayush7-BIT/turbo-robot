#include <bits/stdc++.h>
using namespace std;

int solve(vector<int> &height)
{
    int n = height.size(), mx = 0, ans = 0;
    vector<int> pfxMax(n, 0);

    for (int i = 1; i < n; i++)
    {
        mx = max(mx, height[i - 1]);
        pfxMax[i] = mx;
    }

    for (int i = 0; i < n; i++)
    {
        if (height[i] > pfxMax[i])
        {
            ans++;
        }
    }

    return ans;
}

int main()
{
    /* Input: height = [7, 4, 8, 2, 9]
       Output: 3
       Explanation: As 7 is the first element, it can see the sunrise. 4 can't see the sunrise as 7 is hiding it.
       8 can see. 2 can't see the sunrise. 9 also can see the sunrise.*/

    vector<int> height1 = {7, 4, 8, 2, 9};
    cout << solve(height1) << endl;

    /* Input: height = [2, 3, 4, 5]
       Output: 4
       Explanation: As 2 is the first element, it can see the sunrise.  3 can see the sunrise as 2 is not hiding
       it. Same for 4 and 5, they also can see the sunrise.*/

    vector<int> height2 = {2, 3, 4, 5};
    cout << solve(height2) << endl;
}