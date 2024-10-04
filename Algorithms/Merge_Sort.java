import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
    
    // Main function that sorts arr[] using mergeSort()
    public void sort(int arr[]) {
        if (arr.length < 2) {
            return; // Array is already sorted
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    // Function that performs the merge sort
    private void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the mid point
            
            // Sort the first half
            mergeSort(arr, left, mid);
            // Sort the second half
            mergeSort(arr, mid + 1, right);
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two subarrays of arr[]
    private void merge(int arr[], int left, int mid, int right) {
        // Sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merging the temporary arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        MergeSort ob = new MergeSort();
        System.out.println("Given array: " + Arrays.toString(arr));
        ob.sort(arr); 
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
