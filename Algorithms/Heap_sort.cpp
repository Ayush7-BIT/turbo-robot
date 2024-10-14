#include <iostream>
#define MAX 100
using namespace std;

void heap_sort(int arr[], int size);
void buildHeap(int arr[], int size);
int del_root(int arr[], int *size);
void restoreDown(int arr[], int i, int size);
void display(int arr[], int n);

int main() {
    int i;
    int arr[MAX], n;
    
    cout << "Enter number of elements: ";
    cin >> n;
    
    for (i = 1; i <= n; i++) {
        cout << "Enter element " << i << ": ";
        cin >> arr[i];
    }
    
    cout << "Entered list is: " << endl;
    display(arr, n);

    heap_sort(arr, n);

    cout << "Sorted list is: " << endl;
    display(arr, n);
    return 0;
}

void heap_sort(int arr[], int size) {
    int max;
    buildHeap(arr, size);
    cout << "Heap is: ";
    display(arr, size);
        
    while (size > 1) {
        max = del_root(arr, &size);
        arr[size + 1] = max;
    }
}

void buildHeap(int arr[], int size) {
    int i;
    for (i = size / 2; i >= 1; i--) {
        restoreDown(arr, i, size);
    }
}

int del_root(int arr[], int *size) {
    int max = arr[1];
    arr[1] = arr[*size];
    (*size)--;
    restoreDown(arr, 1, *size);
    return max;
} 

void restoreDown(int arr[], int i, int size) {
    int left = 2 * i, right = left + 1;
    int num = arr[i];
    
    while (right <= size) {
        if (num >= arr[left] && num >= arr[right]) {
            arr[i] = num;
            return;
        } else if (arr[left] > arr[right]) {
            arr[i] = arr[left]; 
            i = left;
        } else {
            arr[i] = arr[right];
            i = right;
        }
        left = 2 * i;
        right = left + 1;
    }

    if (left == size && num < arr[left]) { 
        arr[i] = arr[left];
        i = left;
    }
    arr[i] = num;
} 

void display(int arr[], int n) {       
    for (int i = 1; i <= n; i++) {
        cout << arr[i] << "  ";
    }
    cout << endl;
}
