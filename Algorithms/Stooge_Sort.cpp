#include <iostream>
#include <algorithm>
using namespace std;

void stoogeSort(int arr[], int start, int end) {

    if (start >= end)
        return;

    if (arr[start] > arr[end])
        swap(arr[start], arr[end]);

    if (end - start + 1 > 2) {
        int third = (end - start + 1) / 3;

        stoogeSort(arr, start, end - third);

        stoogeSort(arr, start + third, end);

        stoogeSort(arr, start, end - third);
    }
}

int main() {
    int arr[] = {2, 4, 5, 3, 1};
    int n = sizeof(arr) / sizeof(arr[0]);

    cout << "Original array: ";
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;

    stoogeSort(arr, 0, n - 1);

    cout << "Sorted array: ";
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;

    return 0;
}

