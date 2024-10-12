class RMQSparseTable {
    private int[][] sparseTable;
    private int[] log;

    public RMQSparseTable(int[] arr) {
        int n = arr.length;
        int k = (int) (Math.log(n) / Math.log(2)) + 1;
        sparseTable = new int[n][k];
        log = new int[n + 1];
        preprocess(arr);
    }

    // Preprocess the array to create the Sparse Table
    private void preprocess(int[] arr) {
        int n = arr.length;

        // Fill the log values
        log[1] = 0;
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Initialize sparse table for intervals of length 1
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }

        // Build the sparse table
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query for minimum in range [l, r]
    public int query(int l, int r) {
        int j = log[r - l + 1];
        return Math.min(sparseTable[l][j], sparseTable[r - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 6, 1, 3, 5, 7, 2};
        RMQSparseTable rmq = new RMQSparseTable(arr);
        System.out.println("Min of [3, 8]: " + rmq.query(3, 8));  // Output: 1
        System.out.println("Min of [1, 6]: " + rmq.query(1, 6));  // Output: 1
    }
}
