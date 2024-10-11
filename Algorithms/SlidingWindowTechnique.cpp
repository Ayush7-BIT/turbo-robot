#include <iostream>
#include <vector>
using namespace std;

int maxSumSubarray(const vector<int>& arr, int k) {
    int n = arr.size();
    if (k > n) {
        cout << "Subarray size k is larger than array size!" << endl;
        return -1;
    }
    int max_sum = 0, window_sum = 0;

    for (int i = 0; i < k; ++i) {
        window_sum += arr[i];
    }
    max_sum = window_sum;
  
    // Slide the window over the rest of the array
    for (int i = k; i < n; ++i) {
        // Update the window sum by subtracting the element that is leaving the window
        // and adding the element that is entering the window
        window_sum += arr[i] - arr[i - k];

        // Update the maximum sum
        max_sum = max(max_sum, window_sum);
    }

    return max_sum;
}

int main() {
    vector<int> arr = {2, 1, 5, 1, 3, 2};
    int k = 3;
    int result = maxSumSubarray(arr, k);
    if (result != -1) {
        cout << "Maximum sum of a subarray of size " << k << " is: " << result << endl;
    }

    return 0;
}
