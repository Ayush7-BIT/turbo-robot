#include <iostream>
#include <vector>
#include <algorithm> // For max_element()
using namespace std;

void countingSort(vector<int>& arr) {
    if (arr.empty()) return; // If the array is empty, no need to sort

    // Find the maximum element in the array to determine the size of the count array
    int maxElement = *max_element(arr.begin(), arr.end());

    // Create a count array to store the count of each element, initialized to 0
    vector<int> count(maxElement + 1, 0);

    // Count the occurrences of each element
    for (int num : arr) {
        count[num]++;
    }

    // Reconstruct the sorted array using the count array
    int index = 0;
    for (int i = 0; i <= maxElement; ++i) {
        while (count[i] > 0) {
            arr[index++] = i;
            count[i]--;
        }
    }
}

int main() {
    int n;
    
    // Take user input for the size of the array
    cout << "Enter the number of elements: ";
    cin >> n;
    
    vector<int> arr(n);
    
    // Take user input for array elements
    cout << "Enter the elements: ";
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    
    // Call counting sort to sort the array
    countingSort(arr);
    
    // Output the sorted array
    cout << "Sorted array: ";
    for (int num : arr) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
