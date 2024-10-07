#include<bits/stdc++.h>
using namespace std;

// Function to implement Kadane's Algorithm to find the maximum subarray sum
int kadanes_algo(int n, vector<int>& temp) {
    int max_sum = INT_MIN;  // Initialize max_sum to the smallest possible value
    int curr_sum = 0;       // Initialize current sum to 0

    // Loop through the array
    for (int i = 0; i < temp.size(); i++) {
        curr_sum += temp[i];              // Add the current element to curr_sum
        max_sum = max(max_sum, curr_sum); // Update max_sum if curr_sum is greater

        // If curr_sum becomes negative, reset it to 0 (we ignore negative subarrays)
        if (curr_sum < 0) {
            curr_sum = 0;
        }
    }
    return max_sum;  // Return the maximum subarray sum
}

int main() {
    int n;
    cin >> n;  // Read the size of the array

    vector<int> temp;  // Create a vector to store the array elements

    // Read n elements into the temp vector
    for (int i = 0; i < n; i++) {
        int arr;
        cin >> arr;     // Input each element
        temp.push_back(arr);  // Add the element to the vector
    }

    // Output the result of Kadane's Algorithm
    cout << kadanes_algo(n, temp);

    return 0;
}
