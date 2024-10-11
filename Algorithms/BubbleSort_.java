public class BubbleSort {

    // This method sorts an array using Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length; // Get the length of the array
        boolean swapped; // This will track if we made any swaps

        // Go through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Assume no swaps have been made yet

            // Compare adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // If the current element is greater than the next
                if (array[j] > array[j + 1]) {
                    // Swap them
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true; // We made a swap, so set the flag to true
                }
            }

            // If no swaps happened, the array is sorted, and we can stop
            if (!swapped) {
                break; // Exit the loop early
            }
        }
    }

    // This method prints the elements of the array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " "); // Print each element followed by a space
        }
        System.out.println(); // Move to the next line after printing
    }

    // The main method to test our Bubble Sort
    public static void main(String[] args) {
        // Example array to sort
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Unsorted array:");
        printArray(array); // Show the unsorted array

        bubbleSort(array); // Sort the array

        System.out.println("Sorted array:");
        printArray(array); // Show the sorted array
    }
}
