import java.util.Scanner;

public class BinarySearch {

    // Binary Search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;

        // Get input from user for element to be searched
        Scanner input = new Scanner(System.in);
        System.out.println("Enter element to be searched:");
        int element = input.nextInt();
        input.close();

        // Call the binary search method
        int result = binarySearch(array, element);

        // Print result based on return value of binarySearch
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result);
        }
    }
}
