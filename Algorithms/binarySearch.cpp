#include <iostream>
using namespace std;

// Function to perform binary search on a sorted array
int binarySearch(int arr[], int size, int target)
{
    int left = 0;         // Initialize the left boundary of the search range
    int right = size - 1; // Initialize the right boundary of the search range

    // Loop until the search range is exhausted (left is greater than right)
    while (left <= right)
    {
        // Calculate the middle index of the current search range
        // This avoids overflow compared to (left + right) / 2 for large values of left and right
        int mid = left + (right - left) / 2;

        // Check if the target element is found at the middle position
        if (arr[mid] == target)
        {
            return mid; // Target found, return its index
        }
        // If the target is greater than the middle element, it must be in the right half
        else if (arr[mid] < target)
        {
            left = mid + 1; // Move the left boundary to one position right of mid
        }
        // If the target is less than the middle element, it must be in the left half
        else
        {
            right = mid - 1; // Move the right boundary to one position left of mid
        }
    }

    // If the loop exits, the target was not found, return -1
    return -1;
}

int main()
{
    int size;

    // Prompt the user for the size of the array
    cout << "Enter the number of elements in the array: ";
    cin >> size;

    int arr[size]; // Declare an array of the given size

    // Prompt the user to input elements into the array
    cout << "Enter the sorted elements of the array: ";
    for (int i = 0; i < size; i++)
    {
        cin >> arr[i]; // Store each input element in the array
    }

    int target;

    // Prompt the user for the target element to search for
    cout << "Enter the target element to search: ";
    cin >> target;

    // Call the binary search function with the user's array, size, and target
    int result = binarySearch(arr, size, target);

    // Output the result based on whether the target was found
    if (result != -1)
    {
        // If the result is not -1, the target was found at the returned index
        cout << "Element found at index: " << result << endl;
    }
    else
    {
        // If the result is -1, the target was not found in the array
        cout << "Element not found in the array." << endl;
    }

    return 0;
}

// SAMPLE INPUT:

/* 
Enter the number of elements in the array: 6
Enter the sorted elements of the array: 1 3 5 7 9 11
Enter the target element to search: 7

Element found at index: 3
*/
