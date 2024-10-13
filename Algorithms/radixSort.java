import java.util.Arrays;

public class RadixSort {

    // Method to find the maximum number in the array
    static int findMax(int[] array) {
        int max = array[0]; // Start with the first element
        for (int num : array) {
            if (num > max) {
                max = num; // Update max if current number is greater
            }
        }
        return max; // Return the maximum value found
    }

    // Method to perform counting sort based on a specific digit
    static void countingSortByDigit(int[] array, int placeValue) {
        int n = array.length;
        int[] output = new int[n]; // Output array to hold sorted values
        int[] count = new int[10]; // Count array for digits (0 to 9)

        // Count occurrences of each digit in the current place
        for (int num : array) {
            int digit = (num / placeValue) % 10; // Get the current digit
            count[digit]++; // Increment the count for this digit
        }

        // Modify count array to hold actual positions of digits
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1]; // Cumulative sum
        }

        // Build the output array in sorted order
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / placeValue) % 10; // Current digit
            output[count[digit] - 1] = array[i]; // Place it in the output array
            count[digit]--; // Decrement the count for this digit
        }

        // Copy the output array back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }

    // Main function to sort the array using Radix Sort
    static void radixSort(int[] array) {
        int max = findMax(array); // Find the maximum number
        // Sort for every digit from least significant to most significant
        for (int placeValue = 1; max / placeValue > 0; placeValue *= 10) {
            countingSortByDigit(array, placeValue); // Sort based on the current digit
        }
    }

    // Utility method to print the array
    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " "); // Print each number
        }
        System.out.println(); // New line after printing all numbers
    }

    // Main driver method
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66}; // Sample array
        System.out.println("Original array:");
        printArray(array); // Print the original array

        radixSort(array); // Sort the array using Radix Sort

        System.out.println("Sorted array:");
        printArray(array); // Print the sorted array
    }
}
