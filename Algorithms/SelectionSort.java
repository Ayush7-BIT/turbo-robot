import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] list) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] list1 = {99, 0, 5, 20, 123, 0, -1, 72, 21, 22, 13, 8, 7, 67, 29, 1, 2, 4};
        selectionSort(list1);
        System.out.println(Arrays.toString(list1));

        int[] list2 = {3, 9, 2, 1};
        selectionSort(list2);
        System.out.println(Arrays.toString(list2));
    }
}
