Range Minimum Query (RMQ) using Square Root Decomposition in JavaP:

import java.util.Arrays;

class RMQSquareRootDecomposition {
    int[] arr;    // Original array
    int[] block;  // Array to store block minimums
    int blkSize;  // Size of each block

    // Constructor for preprocessing
    RMQSquareRootDecomposition(int[] input) {
        this.arr = input.clone();
        int n = arr.length;
        blkSize = (int) Math.ceil(Math.sqrt(n));
        block = new int[blkSize];
        
        // Initialize block array
        Arrays.fill(block, Integer.MAX_VALUE);

        // Preprocess the input array into blocks
        for (int i = 0; i < n; i++) {
            int blkIndex = i / blkSize;
            block[blkIndex] = Math.min(block[blkIndex], arr[i]);
        }
    }

    // Range minimum query
    int rangeMinQuery(int L, int R) {
        int min = Integer.MAX_VALUE;
        int startBlock = L / blkSize;
        int endBlock = R / blkSize;

        // If L and R are in the same block, process that block only
        if (startBlock == endBlock) {
            for (int i = L; i <= R; i++) {
                min = Math.min(min, arr[i]);
            }
        } else {
            // Traverse the left partial block
            for (int i = L; i < (startBlock + 1) * blkSize; i++) {
                min = Math.min(min, arr[i]);
            }
            // Traverse all fully covered blocks
            for (int i = startBlock + 1; i < endBlock; i++) {
                min = Math.min(min, block[i]);
            }
            // Traverse the right partial block
            for (int i = endBlock * blkSize; i <= R; i++) {
                min = Math.min(min, arr[i]);
            }
        }

        return min;
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 7, 9, 11, 3, 5, 6, 13, 4};
        RMQSquareRootDecomposition rmq = new RMQSquareRootDecomposition(array);

        // Range minimum queries
        System.out.println("Minimum from index 2 to 8: " + rmq.rangeMinQuery(2, 8)); // Output: 2
        System.out.println("Minimum from index 4 to 6: " + rmq.rangeMinQuery(4, 6)); // Output: 3
        System.out.println("Minimum from index 0 to 10: " + rmq.rangeMinQuery(0, 10)); // Output: 1
    }
}

 Range Minimum Query (RMQ) using Sparse Table in Java:

class RMQSparseTable {
    int[][] sparseTable; // Sparse table to store the minimums
    int[] log;           // Array to store logarithmic values
    int n;               // Length of the input array

    // Constructor for preprocessing
    RMQSparseTable(int[] input) {
        n = input.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;

        sparseTable = new int[n][maxLog];
        log = new int[n + 1];

        // Compute logarithmic values
        log[1] = 0;
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Initialize the first column of the sparse table
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = input[i];
        }

        // Build the sparse table
        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; (i + (1 << j)) <= n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Range minimum query
    int rangeMinQuery(int L, int R) {
        int j = log[R - L + 1];
        return Math.min(sparseTable[L][j], sparseTable[R - (1 << j) + 1][j]);
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 7, 9, 11, 3, 5, 6, 13, 4};
        RMQSparseTable rmq = new RMQSparseTable(array);

        // Range minimum queries
        System.out.println("Minimum from index 2 to 8: " + rmq.rangeMinQuery(2, 8)); // Output: 2
        System.out.println("Minimum from index 4 to 6: " + rmq.rangeMinQuery(4, 6)); // Output: 3
        System.out.println("Minimum from index 0 to 10: " + rmq.rangeMinQuery(0, 10)); // Output: 1
    }
}

