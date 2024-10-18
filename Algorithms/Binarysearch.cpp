#include <iostream>  
using namespace std;
#include <vector>    

using namespace std;

int binarySearch(vector<int>& nums, int target) {
    int left = 0;                          // Initialize the left pointer to the start of the vector
    int right = nums.size() - 1;            // Initialize the right pointer to the end of the vector

    while (left <= right) {                 // Continue while there is a valid subarray
        int mid = left + (right - left) / 2; // Calculate the mid-point to avoid overflow from (left + right) / 2

        // Check if the middle element is the target
        if (nums[mid] == target) {
            return mid;                     // Return the index if target is found
        }
        // If the target is greater than the middle element, ignore the left half
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        // If the target is smaller than the middle element, ignore the right half
        else {
            right = mid - 1;
        }
    }

    return -1; // Return -1 if target is not found in the array
}

int main() {
    vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Define a sorted vector of integers
    int target = 5;                                 // Define the target value to search for

    int index = binarySearch(nums, target);         // Call the binarySearch function

    // Output the result based on whether the target was found or not
    if (index != -1) {
        cout << "Target found at index: " << index << endl;  // If found, print the index
    } else {
        cout << "Target not found" << endl;                  // If not found,  print a message
    }

    return 0;  // Return 0 to indicate successful program execution
}
