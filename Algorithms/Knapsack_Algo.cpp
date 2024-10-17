//*PROBLEM-STATEMENT*//
// We have ( N ) items, each with a specific weight and profit.Additionally, we have a bag with a maximum capacity of ( W ) weight units.
// The goal is to select items to place in the bag so that the total profit is maximized.


#include <bits/stdc++.h>
using namespace std;

int knapsack_Algo(int W, int weights[], int profits[], int n)
{
    int w , i;
    vector<vector<int> > dp(n + 1, vector<int>(W + 1));

    // Tabulation Approach
    for (i = 0; i <= n; i++) {
        for (w = 0; w <= W; w++) {
            if (i == 0 || w == 0) dp[i][w] = 0;
            else if (weights[i - 1] <= w) dp[i][w] = max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
            else dp[i][w] = dp[i - 1][w];
        }
    }
    return dp[n][W];
}

int main()
{
    int W = 70; //maximum weight capacity of bag
    int profit[] = { 40, 120, 80, 200, 50 }; // profit array
    int weight[] = { 5, 40, 30, 80, 20 };    //coresponding weight array
    int N = sizeof(profit) / sizeof(profit[0]);
    
    int maximum_profit = knapsack_Algo(W, weight, profit, N);
    cout <<"Maximum Profit that can be obtained is : "<<maximum_profit<<endl;

    return 0;
}

// Time Complexity: O(N * W). 
// Here ‘N’ is the number of elements and ‘W’ is maximum weigth capacity capacity. 

// Auxiliary Space: O(N * W).
// Beacuse of the use of a 2-D array of size ‘N*W’.



// Tabulation Approach Explained :
// The algorithm uses a bottom-up approach to fill the dp table:
//     -> If either the item count i or the capacity w is zero, the profit is zero.
//     -> If the weight of the current item is less than or equal to the current capacity, the algorithm decides whether to include the item or not by comparing the profit of including the item with the profit of excluding it.
//     -> If the weight of the current item exceeds the current capacity, the item is excluded.