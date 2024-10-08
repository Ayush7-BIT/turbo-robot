#include <iostream>
#include <algorithm>
using namespace std;

// A function to get the maximum value in an array
int getMax(int arr[], int size) {
    int max = arr[0];
    for (int i = 1; i < size; i++) {
        if (arr[i] > max)
            max = arr[i];
    }
    return max;
}

// A function to perform counting sort based on the digit represented by exp (10^n)
void countingSort(int arr[], int size, int exp) {
    int output[size]; // Output array
    int count[10] = {0}; // Initialize count array as 0

    // Store count of occurrences in count[]
    for (int i = 0; i < size; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    // Change count[i] so that count[i] contains the actual position of this digit in output[]
    for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
    }

    // Build the output array
    for (int i = size - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
    for (int i = 0; i < size; i++) {
        arr[i] = output[i];
    }
}

// The main function to implement Radix Sort
void radixSort(int arr[], int size) {
    // Find the maximum number to know the number of digits
    int max = getMax(arr, size);

    // Do counting sort for every digit. The exp is 10^i (i = 0, 1, 2, ...)
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSort(arr, size, exp);
    }
}

int main() {
    int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
    int size = sizeof(arr) / sizeof(arr[0]);

    radixSort(arr, size);

    cout << "Sorted array: ";
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
