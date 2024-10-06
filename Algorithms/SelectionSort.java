import java.util.*;
class Solution {

  public int[] selectionSort(int[] nums) {
    // Loop through unsorted part of the array (0 to n-2)
    for (int i = 0; i < nums.length - 1; i++) {
      /*Assume current element 
      is the minimum*/
      int minIndex = i;

      // Find actual minimum in unsorted part (i+1 to n-1)
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }

      // Swap only if minIndex changed
      if (minIndex != i) {
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
      }
    }

    return nums;
  }
}

public class Main {

  public static void main(String[] args) {
    int[] arr = {7, 5, 9, 2, 8};

    System.out.print("Original array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();

    // create an instance of solution class
    Solution solution = new Solution();

    // function call for selection sort
    int[] sortedArr = solution.selectionSort(arr);

    System.out.print("Sorted array: ");
    for (int num : sortedArr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}
