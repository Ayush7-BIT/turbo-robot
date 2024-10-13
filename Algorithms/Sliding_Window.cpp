#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxSumSubarray(vector<int>& arr, int k) {
    int windowSum = 0;
    int maxSum = INT_MIN;

    int left = 0;
    int right = 0;

    while (right < k) {
        windowSum += arr[right];
        right++;
    }

    maxSum = max(maxSum, windowSum);

    while (right < arr.size()) {
        windowSum -= arr[left];
        left++;

        windowSum += arr[right];
        right++;

        maxSum = max(maxSum, windowSum);
    }

    return maxSum;
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int k = 3;
    int maxSum = maxSumSubarray(arr, k);

    cout << "Maximum sum of a subarray of size " << k << " is " << maxSum << endl;

    return 0;
}
