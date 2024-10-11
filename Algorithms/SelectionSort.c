// Selection Sort
#include <stdio.h>
void sort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int min = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min])
                min = j;
        }
        int tmp = arr[i];
        arr[i] = arr[min];
        arr[min] = tmp;
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