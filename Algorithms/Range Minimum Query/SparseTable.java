public class RMQSparseTable {
    private int[][] sparseTable;
    private int[] log;
    private int n;

    public RMQSparseTable(int[] arr) {
        n = arr.length;
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }
        int k = log[n] + 1;
        sparseTable = new int[n][k];
        preprocess(arr);
    }

    private void preprocess(int[] arr) {
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; (i + (1 << j) - 1) < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public int query(int l, int r) {
        int j = log[r - l + 1];
        return Math.min(sparseTable[l][j], sparseTable[r - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 3, 5, 6, 4};
        RMQSparseTable rmq = new RMQSparseTable(arr);
        System.out.println("Minimum value between indices 1 and 5: " + rmq.query(1, 5));
        System.out.println("Minimum value between indices 4 and 9: " + rmq.query(4, 9));
    }
}
