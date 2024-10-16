#include <iostream>
using namespace std;

void dutchNationalFlag(int arr[], int size) {
    int low = 0, mid = 0, high = size - 1;

    while (mid <= high) {
        switch (arr[mid]) {
            case 0:
                swap(arr[low++], arr[mid++]); // Move 0 to the low region
                break;
            case 1:
                mid++; // 1 stays in the middle
                break;
            case 2:
                swap(arr[mid], arr[high--]); // Move 2 to the high region
                break;
        }
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    int arr[] = {2, 0, 2, 1, 1, 0, 2, 1, 0};
    int size = sizeof(arr) / sizeof(arr[0]);

    cout << "Original Array: ";
    printArray(arr, size);

    dutchNationalFlag(arr, size);

    cout << "Sorted Array: ";
    printArray(arr, size);

    return 0;
}
