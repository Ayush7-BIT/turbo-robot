public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 4, 2, 7, 5};
        findDuplicates(arr);
    }

    public static void findDuplicates(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[maxVal + 1];

        System.out.print("Duplicates: ");
        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 0; i <= maxVal; i++) {
            if (freq[i] > 1) {
                System.out.print(i + " ");
            }
        }
    }
}
