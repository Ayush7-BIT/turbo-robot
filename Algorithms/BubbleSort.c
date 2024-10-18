// Bubble Sort
#include <stdio.h>
void sort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 1; j < n - i; j++) {
            if (arr[j - 1] > arr[j]) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
            }
        }
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
    sort(arr, n);
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}