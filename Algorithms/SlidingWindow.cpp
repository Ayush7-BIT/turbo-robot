// This Code implements sliding window technique in C++

#include <iostream>
using namespace std;

int maxSumSubarray(int arr[], int n, int k) {
    if (n < k) {
        cout << "Invalid input: k is larger than the array size." << endl;
        return -1;
    }

    int windowSum = 0;
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }

    int maxSum = windowSum;

    for (int i = k; i < n; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = max(maxSum, windowSum);
    }

    return maxSum;
}

int main() {
    int arr[] = {2, 1, 5, 1, 3, 2, 6, 8, 5, 9};
    int n = sizeof(arr) / sizeof(arr[0]);
    int k = 3;

    int result = maxSumSubarray(arr, n, k);

    if (result != -1) {
        cout << "The maximum sum of a subarray of size " << k << " is: " << result << endl;
    }

    return 0;
}
