import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Find the maximum element in the array to determine the range
        int max = Arrays.stream(array).max().getAsInt();

        // Create a count array to store the frequency of each element
        int[] countArray = new int[max + 1];

        // Fill the count array
        for (int num : array) {
            countArray[num]++;
        }

        // Sort the original array using the count array
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[index++] = i;
                countArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(array));

        // Perform counting sort
        countingSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        scanner.close();
    }
}
