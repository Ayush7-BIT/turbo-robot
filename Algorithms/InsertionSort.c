// Insertion Sort
#include <stdio.h>
void sort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int tmp = arr[i], j = i;
        while (j > 0 && arr[j - 1] > tmp) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = tmp;
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