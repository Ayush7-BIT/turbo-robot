public class RMQSparseTable {
    int[][] sparseTable;
    int[] log;
    int n;

    // Constructor to preprocess input array
    public RMQSparseTable(int[] arr) {
        this.n = arr.length;
        this.log = new int[n + 1];
        preprocessLog();
        preprocessSparseTable(arr);
    }

    // Preprocess the log values
    private void preprocessLog() {
        log[1] = 0;
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }
    }

    // Preprocess sparse table for range minimum queries
    private void preprocessSparseTable(int[] arr) {
        int k = log[n] + 1; // Maximum power of 2 less than or equal to n
        sparseTable = new int[n][k];

        // Initialize sparse table for the intervals of length 1
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }

        // Build the table for larger intervals
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query the minimum value in the range [L, R]
    public int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(sparseTable[L][j], sparseTable[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 3, 5, 8, 12};
        RMQSparseTable rmq = new RMQSparseTable(arr);

        System.out.println("Min between (1, 6): " + rmq.query(1, 6)); // Output: 2
        System.out.println("Min between (3, 9): " + rmq.query(3, 9)); // Output: 3
    }
}
