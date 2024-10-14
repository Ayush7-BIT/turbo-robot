import java.util.Arrays;

public class CountingSort {
    // Function to perform counting sort on the array
    public static void countingSort(int[] arr) {
        // Find the maximum element in the array to determine the size of the count array
        int max = Arrays.stream(arr).max().getAsInt();

        // Create a count array to store the count of each element, and initialize it to 0
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int num : arr) {
            count[num]++;
        }

        // Rebuild the original array from the count array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(arr));

        countingSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
