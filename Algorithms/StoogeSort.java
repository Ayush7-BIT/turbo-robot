public class StoogeSort {

    // Function for stooge sort
    public static void stoogeSort(int[] arr, int l, int h) {
        // If the first element is greater than the last, swap them
        if (arr[l] > arr[h]) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }

        // If there's more than two elements in the array
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;

            // Recursively sort first 2/3 of the array
            stoogeSort(arr, l, h - t);

            // Recursively sort last 2/3 of the array
            stoogeSort(arr, l + t, h);

            // Again, recursively sort first 2/3 of the array
            stoogeSort(arr, l, h - t);
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {5, 7, 3, 2, 8, 1, 9};

        // Call the sorting function
        stoogeSort(arr, 0, arr.length - 1);

        // Print sorted array
        System.out.print("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
