import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for size
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("Before sorting:");
        for (int num : nums) {
            System.out.println(num);
        }

        // Selection sort logic
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        // Output
        System.out.println("After sorting:");
        for (int num : nums) {
            System.out.println(num);
        }

        scanner.close();
    }
}
