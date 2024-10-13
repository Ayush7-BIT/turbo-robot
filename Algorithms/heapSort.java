public class HeapSort {

    // Main function to perform heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            swap(arr, 0, i);

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to maintain the heap property
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If the left child is larger than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest); // Recursively heapify the affected subtree
        }
    }

    // Utility function to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Driver method to test the heap sort implementation
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Function to print the array
    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
