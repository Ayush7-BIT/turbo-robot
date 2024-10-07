#include<iostream>
using namespace std;

int linearSearch(int arr[], int size, int k) {
    for(int i=0; i<size; i++) {
        if(arr[i] == k) return i;

    }
    return -1;
}

int main() {
    int arr[10] = {1, 5, -7, 4, 3, 6, 9, 98, 35, -29};

    // Linear search finds if a target element exists in given array and returns its index. If it does not exist then it returns -1;
    int search10 = linearSearch(arr, 10, 10); // return -1
    int search98 = linearSearch(arr, 10, 98); // return 7

    return 0; 
}