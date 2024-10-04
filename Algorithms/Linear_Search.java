//Linear Search Optimised Approach using Two-Pointers
public class TwoPointerLinearSearch {

    // Function to perform two-pointer linear search
    public static int twoPointerSearch(int[] arr, int target) {
        // Define two pointers: one starting at the beginning and one at the end
        int left = 0;
        int right = arr.length - 1;

        // Continue until both pointers meet
        while (left <= right) {
            // Check if the element at the left pointer is the target
            if (arr[left] == target) {
                return left; // Return the index of the found element
            }

            // Check if the element at the right pointer is the target
            if (arr[right] == target) {
                return right; // Return the index of the found element
            }

            // Move pointers inward
            left++;
            right--;
        }

        // Return -1 if the target is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 8, 9, 1, 5};
        int target = 9;
        int result = twoPointerSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
