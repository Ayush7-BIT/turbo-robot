/**
 * This class implements an iterative binary search algorithm.
 * 
 * Purpose: To find the index of a given element in a sorted array.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Use Cases: Efficiently searching for an element in a sorted dataset.
 */
class BinarySearch {

    /**
     * Performs binary search on a sorted array.
     *
     * @param arr The sorted array to search.
     * @param x   The element to search for.
     * @return The index of the element if found, otherwise -1.
     */
    int searchInSortedArray(int arr[], int x) {
        // Validate input
        if (arr == null || arr.length == 0) {
            return -1; // Return -1 for null or empty arrays
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            // Calculate mid to avoid potential overflow
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x) {
                return mid; // Element found
            }

            // If x is greater, ignore left half
            if (arr[mid] < x) {
                low = mid + 1; // Move the lower bound up
            } else {
                // If x is smaller, ignore right half
                high = mid - 1; // Move the upper bound down
            }
        }

        return -1; // Element not present in array
    }

    /**
     * Driver code to test the binary search implementation.
     */
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40}; // Sample sorted array
        int x = 10; // Element to search for
        
        int result = ob.searchInSortedArray(arr, x);
        
        if (result == -1) {
            System.out.println("Element is not present in array");
        } else {
            System.out.println("Element is present at index " + result);
        }
        
        // Additional test cases
        System.out.println("Testing additional cases:");
        System.out.println("Searching for 2: " + ob.searchInSortedArray(arr, 2)); // Should return index 0
        System.out.println("Searching for 40: " + ob.searchInSortedArray(arr, 40)); // Should return index 4
        System.out.println("Searching for 5: " + ob.searchInSortedArray(arr, 5)); // Should return -1
        System.out.println("Searching in an empty array: " + ob.searchInSortedArray(new int[]{}, 10)); // Should return -1
        System.out.println("Searching in a null array: " + ob.searchInSortedArray(null, 10)); // Should return -1
    }
}