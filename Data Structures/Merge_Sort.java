import java.util.Arrays;

public class MergeSort {

    // Main function that sorts the array using merge sort
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Base case: arrays with 0 or 1 elements are already sorted
        }

        int mid = array.length / 2; // Find the middle index
        int[] left = Arrays.copyOfRange(array, 0, mid); // Left half
        int[] right = Arrays.copyOfRange(array, mid, array.length); // Right half

        mergeSort(left);  // Sort the left half
        mergeSort(right); // Sort the right half

        merge(array, left, right); // Merge the sorted halves
    }

    // Function to merge two sorted arrays
    public static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++]; // Add left element to result
            } else {
                result[k++] = right[j++]; // Add right element to result
            }
        }

        // Copy remaining elements from the left array (if any)
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements from the right array (if any)
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Main method to test the merge sort implementation
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array: " + Arrays.toString(array));
        
        mergeSort(array); // Sort the array using merge sort
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
