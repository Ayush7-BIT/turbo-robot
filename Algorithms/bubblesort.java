public class BubbleSort {
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Call the bubbleSort method
        bubbleSort(arr);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Method to perform bubble sort
    static void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array

        // Loop through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if the element found is greater
                    // than the next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Method to print the array
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " "); // Print each element
        }
        System.out.println(); // Move to the next line
    }
}
