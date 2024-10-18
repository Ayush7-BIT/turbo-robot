import java.util.Arrays;

class RangeMinimumQuerySparseTable {
    int[][] sparseTable;
    int[] log;
    int n;

    public RangeMinimumQuerySparseTable(int[] arr) {
        n = arr.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        sparseTable = new int[n][maxLog];
        log = new int[n + 1];

        // Precompute logarithms
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Initialize sparse table for the intervals of length 1
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }

        // Compute values for intervals of length 2^j
        for (int j = 1; j <= log[n]; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query the minimum in range [L, R]
    public int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(sparseTable[L][j], sparseTable[R - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 7, 9, 11, 3, 5, 8};
        RangeMinimumQuerySparseTable rmq = new RangeMinimumQuerySparseTable(input);

        System.out.println("Minimum of range (1, 6): " + rmq.query(1, 6));
        System.out.println("Minimum of range (0, 4): " + rmq.query(0, 4));
    }
}

