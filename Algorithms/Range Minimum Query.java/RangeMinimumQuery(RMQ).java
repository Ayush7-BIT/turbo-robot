//Square Root Decomposition (Alternative Approach)

import java.util.Arrays;

public class RMQSquareRootOptimized {
    private int[] arr;
    private int[] blockMin;
    private int blockSize;

    public RMQSquareRootOptimized(int[] input) {
        this.arr = input.clone(); // Use clone to avoid modifying the original array
        int n = input.length;
        blockSize = (int) Math.ceil(Math.sqrt(n));
        blockMin = new int[blockSize];
        Arrays.fill(blockMin, Integer.MAX_VALUE);
        preprocess();
    }

    // Preprocess to compute minimum in each block
    private void preprocess() {
        for (int i = 0; i < arr.length; i++) {
            int blockIdx = i / blockSize;
            blockMin[blockIdx] = Math.min(blockMin[blockIdx], arr[i]);
        }
    }

    // Query for the minimum value in the range [l, r]
    public int query(int l, int r) {
        int minVal = Integer.MAX_VALUE;

        int leftBlock = l / blockSize;
        int rightBlock = r / blockSize;

        // If the query range is within a single block
        if (leftBlock == rightBlock) {
            for (int i = l; i <= r; i++) {
                minVal = Math.min(minVal, arr[i]);
            }
        } else {
            // Traverse the elements of the first (left) partial block
            for (int i = l; i < (leftBlock + 1) * blockSize; i++) {
                minVal = Math.min(minVal, arr[i]);
            }
            // Traverse fully covered blocks
            for (int i = leftBlock + 1; i < rightBlock; i++) {
                minVal = Math.min(minVal, blockMin[i]);
            }
            // Traverse the elements of the last (right) partial block
            for (int i = rightBlock * blockSize; i <= r; i++) {
                minVal = Math.min(minVal, arr[i]);
            }
        }
        return minVal;
    }

    // Update a specific element and recalculate its block's minimum
    public void update(int idx, int value) {
        int blockIdx = idx / blockSize;
        arr[idx] = value;

        // Recalculate the minimum for the updated block
        blockMin[blockIdx] = Integer.MAX_VALUE;
        int start = blockIdx * blockSize;
        int end = Math.min(start + blockSize, arr.length);

        for (int i = start; i < end; i++) {
            blockMin[blockIdx] = Math.min(blockMin[blockIdx], arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 2, 4, 6, 1, 3, 5, 7, 8, 9, 1, 6};
        RMQSquareRootOptimized rmq = new RMQSquareRootOptimized(input);

        System.out.println(rmq.query(2, 5));  // Output: 1
        rmq.update(4, 0);
        System.out.println(rmq.query(2, 5));  // Output: 0
    }
}


//Sparse Table (Alternative Approach)

public class RMQSparseTableOptimized {
    private int[][] sparseTable;
    private int[] log;
    private int length;

    public RMQSparseTableOptimized(int[] input) {
        this.length = input.length;
        preprocessLogValues();
        buildSparseTable(input);
    }

    // Preprocess log values for dynamic interval length computation
    private void preprocessLogValues() {
        log = new int[length + 1];
        log[1] = 0;
        for (int i = 2; i <= length; i++) {
            log[i] = log[i / 2] + 1;
        }
    }

    // Build the Sparse Table
    private void buildSparseTable(int[] arr) {
        int maxPow = log[length] + 1;
        sparseTable = new int[length][maxPow];

        // Initialize for intervals of length 1
        for (int i = 0; i < length; i++) {
            sparseTable[i][0] = arr[i];
        }

        // Build the table for intervals of length 2^j
        for (int j = 1; (1 << j) <= length; j++) {
            for (int i = 0; (i + (1 << j)) <= length; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query the minimum value between indices l and r
    public int query(int l, int r) {
        int range = r - l + 1;
        int logRange = log[range];
        return Math.min(sparseTable[l][logRange], sparseTable[r - (1 << logRange) + 1][logRange]);
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 1, 5, 7, 3, 9, 8, 2, 10};
        RMQSparseTableOptimized rmq = new RMQSparseTableOptimized(input);

        System.out.println(rmq.query(1, 3));  // Output: 1
        System.out.println(rmq.query(4, 8));  // Output: 2
    }
}
