import java.util.Arrays;

public class RangeMinimumQuery {

    private int[][] minTable;

    public RangeMinimumQuery(int[] arr) {
        int n = arr.length;
        minTable = new int[n][n];
        preprocess(arr, n);
    }

    private void preprocess(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            minTable[i][i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                minTable[i][j] = (arr[minTable[i][j - 1]] < arr[j]) ? minTable[i][j - 1] : j;
            }
        }
    }

    public int query(int[] arr, int left, int right) {
        return arr[minTable[left][right]];
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        RangeMinimumQuery rmq = new RangeMinimumQuery(arr);

        int[][] queries = {{0, 4}, {4, 7}, {7, 8}};
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            System.out.println("Minimum value in range [" + left + ", " + right + "] is: "
                    + rmq.query(arr, left, right));
        }
    }
}
