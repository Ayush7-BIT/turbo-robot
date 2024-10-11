// Quick Sort
#include <stdio.h>
int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int tmp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = tmp;
    return (i + 1);
}
void sort(int arr[], int low, int high) {
    if (low < high) {
        int p = partition(arr, low, high);
        sort(arr, low, p - 1);
        sort(arr, p + 1, high);
    }
}
int main() {
    int n;
    printf("Enter Number of Element : ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter Array Elements : \n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    sort(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}