#include <bits/stdc++.h>
using namespace std;

// Function for Binary Search
int binarySearch(int arr[], int x, int start, int end)
{
    while (start <= end)
    {
        int mid = start + (end - start) / 2;

        // If x is present at the mid of the array
        if (arr[mid] == x)
        {
            return mid;
        }

        // If x is greater than the number at mid of the array, ignore left half of the array
        if (arr[mid] < x)
        {
            start = mid + 1;
        }

        // If x is smaller than the number at mid of the array, ignore right half of the array
        else
        {
            end = mid - 1;
        }
    }

    // If the code reaches here, this means that the element is not present in the array
    return -1;
}

int main()
{
    int arr[] = {4, 5, 8, 34, 46, 57, 67, 98, 100};
    int x;
    cout << "Enter the element to be searched: ";
    cin >> x;
    int n = sizeof(arr) / sizeof(arr[0]);
    int position = binarySearch(arr, x, 0, n - 1);
    if (position == -1)
        cout << "The element is not present in the array" << endl;
    else
        cout << "The element is present at index " << position << " in the array" << endl;
    return 0;
}