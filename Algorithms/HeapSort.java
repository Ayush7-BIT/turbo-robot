import java.util.Arrays;

class HeapSort {

    // Main function to sort an array using heap sort
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move the current root (maximum) to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree rooted with node i, which is an index in array[].
    // n is the size of the heap
    private static void heapify(int[] array, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 
        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }

    // Main method to test the heap sort implementation
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
