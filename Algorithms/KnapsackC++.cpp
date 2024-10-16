/*
The Knapsack Problem is a classic optimization problem in computer science and mathematics. The problem gets its name from the scenario of packing items into a knapsack (or backpack) to maximize the value of the items, while staying within a weight or capacity limit. The challenge is to choose the most valuable combination of items without exceeding the knapsack's capacity. The problem has several variations, but the most well-known and studied one is the 0/1 Knapsack Problem.

 0/1 Knapsack Problem
In this version, each item can either be included (1) or excluded (0). The decision is binary for each item. You can't take a fraction of an item, nor can you take an item more than once.

Problem Statement:
You have n items, each with:
A weight 𝑤𝑖 (how heavy the item is)
A value 𝑣𝑖 (how valuable the item is)
The knapsack has a weight capacity 𝑊
The goal is to maximize the total value of items in the knapsack without exceeding its weight limit.

*/

#include <bits/stdc++.h> // importing the parent header file that contains all the useful header files

using namespace std;

int knapsack(vector<int> &weight, vector<int> &price, int bagCapacity)
{
    // getting the number of items
    int n = weight.size();
    // here, we are using Dynamic Programming approach to solve this problem

    /* We declare a 2D matrix of size (n+1) * (bagCapacity+1) and initialize all the elements to 0
        dp[i][j] -> best possible ans for i number of items when the capacity left is j units
    */
    vector<vector<int>> dp(n + 1, vector<int>(bagCapacity + 1, 0));

    // Now, we start with our tabulation method
    for (int i = 1; i <= n; i++) // looping over the items
    {
        for (int j = 0; j <= bagCapacity; j++) // taking the best ans for all bag capacities
        {
            int notTake = dp[i - 1][j]; // case where you are not picking any item

            int take = 0; // case where you pick an item so you need to add up its price
            if (j >= weight[i - 1])
            {
                take = price[i - 1] + dp[i - 1][j - weight[i - 1]]; // pick item i-1
            }

            // calculating the best possibility at each step
            dp[i][j] = max(take, notTake);
        }
    }
    return dp[n][bagCapacity]; // it will contain the best possible answer for all the n items
}

int main()
{
    int n; // n is the number of items
    cin >> n;
    int bagCapacity; // this denotes the capacity of the bag in which the items are to be stored
    cin >> bagCapacity;

    vector<int> weight(n); // this vector contains the weights of all the n items
    vector<int> price(n);  // this vector contains the price of all the n items

    for (int i = 0; i < n; i++) // inserting the weights
    {
        cin >> weight[i];
    }
    for (int i = 0; i < n; i++) // inserting the prices
    {
        cin >> price[i];
    }

    int ans = knapsack(weight, price, bagCapacity); // calling the knapsack function to get our ans
    cout << ans << endl;
    return 0;
}