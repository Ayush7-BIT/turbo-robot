public class SimpleMergeSort {

    // Main method to sort the array
    public void sort(int[] array) {
        if (array.length > 1) { // Only sort if there is more than one element
            mergeSort(array, 0, array.length - 1);
        }
    }

    // Recursive method to divide the array
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) { // Check if the left index is less than the right index
            int mid = (left + right) / 2; // Find the middle index

            // Sort the left and right halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Method to merge two sorted halves
    private void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1]; // Left sub-array
        int[] rightArray = new int[right - mid]; // Right sub-array

        // Copy data to left and right arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < rightArray.length; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left; // Indexes for left, right, and merged array

        // Merge the arrays
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]; // Add from left array
                i++;
            } else {
                array[k] = rightArray[j]; // Add from right array
                j++;
            }
            k++;
        }

        // Copy remaining elements from left array
        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        SimpleMergeSort sorter = new SimpleMergeSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10}; // Sample array

        System.out.println("Original Array:");
        sorter.printArray(array); // Print original array

        sorter.sort(array); // Sort the array

        System.out.println("\nSorted Array:");
        sorter.printArray(array); // Print sorted array
    }

    // Method to print the array
    private void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " "); // Print each element
        }
        System.out.println(); // New line after printing all elements
    }
}
