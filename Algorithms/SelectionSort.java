import java.util.*;

class Solution {

  // Method to implement Selection Sort
  public int[] selectionSort(int[] numbers) {
    
    // Loop through the unsorted part of the array (from index 0 to n-2)
    for (int i = 0; i < numbers.length - 1; i++) {
      
      // Assume the current element at index 'i' is the smallest
      int smallestIndex = i;

      // Find the actual smallest element in the unsorted part (from i+1 to the end)
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[j] < numbers[smallestIndex]) {
          // Update the smallestIndex if a smaller element is found
          smallestIndex = j;
        }
      }

      // Swap the current element with the smallest element found, if needed
      if (smallestIndex != i) {
        int temp = numbers[i];
        numbers[i] = numbers[smallestIndex];
        numbers[smallestIndex] = temp;
      }
    }

    // Return the sorted array
    return numbers;
  }
}

public class Main {

  public static void main(String[] args) {
    // Initialize an unsorted array
    int[] array = {66, 2, 35, 1, 99, 2, 0};

    // Print the original array
    System.out.print("Original array: ");
    for (int number : array) {
      System.out.print(number + " ");
    }
    System.out.println();

    // Create an instance of the Solution class
    Solution solution = new Solution();

    // Call the selectionSort function and store the sorted array
    int[] sortedArray = solution.selectionSort(array);

    // Print the sorted array
    System.out.print("Sorted array: ");
    for (int number : sortedArray) {
      System.out.print(number + " ");
    }
    System.out.println();
  }
}
