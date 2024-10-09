public class BinarySearch {

    // Binary Search using iterative method
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

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

    public static void main(String[] args) {
        int[] Array = {2, 5, 7, 10, 14, 20, 25};
        int target = 14;

        int result = binarySearch(Array, target);

        if (result != -1) {
            System.out.println("Target element found at index: " + result);
        } else {
            System.out.println("Target element not found! ");
        }
    }
}
