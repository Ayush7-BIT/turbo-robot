#include <iostream>
using namespace std;
int a[] = {20,40,23,17,9,0};
int n = sizeof(a)/sizeof(a[0]);

void bubbleSort(int a[], int n) {
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            // Swap if element greater then next element
            if (a[j] > a[j+1]) {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }
}

void printArray(int a[], int n) {
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << endl;
}

int main() {
    cout << "Unsorted array: ";
    printArray(a, n);
    
    bubbleSort(a, n);
    
    cout << "Sorted array: ";
    printArray(a, n);
    
    return 0;
}
