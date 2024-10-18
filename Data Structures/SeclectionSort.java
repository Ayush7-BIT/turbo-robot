import java.util.Arrays;

public class SelectionSort {
    
    // Function to implement selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Traverse through the array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the remaining unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // Main function to test the selection sort
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("Original array: " + Arrays.toString(arr));
        
        selectionSort(arr); // Sorting the array
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
