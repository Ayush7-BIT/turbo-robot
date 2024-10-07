/**
 * BinarySearch.java
 * 
 * This class implements a simple Binary Search algorithm for an array of integers.
 * It includes a unique feature of tracking the number of comparisons made during the search.
 *
 * @author https://manishraj.me
 * @version 1.1
 * @since 2024-10-08
 */
public class SimpleBinarySearch {

    private int comparisons;

    /**
     * Performs a binary search on the given sorted array and tracks the number of comparisons.
     *
     * @param arr The sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    public int search(int[] arr, int target) {
        comparisons = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Gets the number of comparisons made during the last search.
     *
     * @return The number of comparisons.
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * Main method to demonstrate the usage of the simple binary search algorithm.
     */
    public static void main(String[] args) {
        SimpleBinarySearch searcher = new SimpleBinarySearch();
        int[] sortedArray = {5, 8, 12, 30, 98};
        int target = 12;

        int result = searcher.search(sortedArray, target);
        
        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index " + result);
        }
        
        System.out.println("Number of comparisons made: " + searcher.getComparisons());
    }
}
