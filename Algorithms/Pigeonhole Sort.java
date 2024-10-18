import java.util.*;

public class PigeonholeSort {
    public static void pigeonholeSort(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int range = max - min + 1;

        List<Integer>[] pigeonholes = new ArrayList[range];
        for (int i = 0; i < range; i++) {
            pigeonholes[i] = new ArrayList<>();
        }

        for (int num : arr) {
            pigeonholes[num - min].add(num);
        }

        int index = 0;
        for (List<Integer> hole : pigeonholes) {
            for (int num : hole) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 7, 4, 6, 8};
        System.out.println("Given Array: " + Arrays.toString(arr));

        pigeonholeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
