import java.util.*;

class RMQ {
    private int[] arr;
    private int[] blockMin;
    private int blockSize;
    private int[][] sparseTable;
    private int[] log;

    public RMQ(int[] input) {
        this.arr = input;
        initSquareRootDecomposition();
        initSparseTable();
    }

    // Square Root Decomposition
    private void initSquareRootDecomposition() {
        int n = arr.length;
        blockSize = (int) Math.sqrt(n);
        int numBlocks = (n + blockSize - 1) / blockSize;
        blockMin = new int[numBlocks];
        Arrays.fill(blockMin, Integer.MAX_VALUE);
        
        for (int i = 0; i < n; i++) {
            int blockIndex = i / blockSize;
            blockMin[blockIndex] = Math.min(blockMin[blockIndex], arr[i]);
        }
    }

    public int querySquareRoot(int l, int r) {
        int min = Integer.MAX_VALUE;
        while (l <= r && l % blockSize != 0) {
            min = Math.min(min, arr[l]);
            l++;
        }
        while (l + blockSize <= r) {
            min = Math.min(min, blockMin[l / blockSize]);
            l += blockSize;
        }
        while (l <= r) {
            min = Math.min(min, arr[l]);
            l++;
        }
        return min;
    }

    // Sparse Table
    private void initSparseTable() {
        int n = arr.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        sparseTable = new int[n][maxLog];
        log = new int[n + 1];

        for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;

        for (int i = 0; i < n; i++) sparseTable[i][0] = arr[i];

        for (int j = 1; j <= log[n]; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public int querySparseTable(int l, int r) {
        int j = log[r - l + 1];
        return Math.min(sparseTable[l][j], sparseTable[r - (1 << j) + 1][j]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 9, 3};
        RMQ rmq = new RMQ(arr);

        System.out.println("Square Root Query (0, 5): " + rmq.querySquareRoot(0, 5)); // Output: 1
        System.out.println("Sparse Table Query (0, 5): " + rmq.querySparseTable(0, 5)); // Output: 1
    }
}
