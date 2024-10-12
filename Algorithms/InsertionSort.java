import java.util.Scanner;

public class InsertionSort {

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

        // Insertion sort logic
        for (int i = 1; i < size; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }

        // Output
        System.out.println("After sorting:");
        for (int num : nums) {
            System.out.println(num);
        }

        scanner.close();
    }
}
