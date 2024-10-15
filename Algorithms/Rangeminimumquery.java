// Square Root Decomposition for RMQ:

import java.util.Arrays;

public class RangeMinQuerySqrtDecomposition {
    private int[] arr;
    private int[] block;
    private int blockSize;

    // Initialize the array and preprocess blocks
    public RangeMinQuerySqrtDecomposition(int[] input) {
        arr = input;
        blockSize = (int) Math.sqrt(arr.length);
        block = new int[(arr.length + blockSize - 1) / blockSize];
        Arrays.fill(block, Integer.MAX_VALUE); // Initialize blocks to maximum values

        // Preprocess the blocks with minimums
        for (int i = 0; i < arr.length; i++) {
            int blockIndex = i / blockSize;
            block[blockIndex] = Math.min(block[blockIndex], arr[i]);
        }
    }

    // Function to get the minimum value in a range [left, right]
    public int rangeMinQuery(int left, int right) {
        int minVal = Integer.MAX_VALUE;

        // Traverse from left to right
        while (left <= right) {
            if (left % blockSize == 0 && left + blockSize - 1 <= right) {
                // If the whole block is within the range
                minVal = Math.min(minVal, block[left / blockSize]);
                left += blockSize; // Skip the whole block
            } else {
                // Traverse element by element
                minVal = Math.min(minVal, arr[left]);
                left++;
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 7, 9, 11, 3, 5, 1, 0};
        RangeMinQuerySqrtDecomposition rmq = new RangeMinQuerySqrtDecomposition(input);
        
        System.out.println("Range Min Query (2, 8): " + rmq.rangeMinQuery(2, 8)); // Output: 1
        System.out.println("Range Min Query (0, 5): " + rmq.rangeMinQuery(0, 5)); // Output: 1
    }
}

// Sparse table for RMQ: 
import java.util.Arrays;

public class RangeMinQuerySparseTable {
    private int[][] sparseTable;
    private int[] log;

    // Preprocess the input array to build the sparse table
    public RangeMinQuerySparseTable(int[] input) {
        int n = input.length;
        log = new int[n + 1];
        sparseTable = new int[n][log2(n) + 1];

        // Precompute log values
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // Initialize the sparse table with input array values
        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = input[i];
        }

        // Build the sparse table
        for (int j = 1; j <= log[n]; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Function to get the minimum value in a range [left, right]
    public int rangeMinQuery(int left, int right) {
        int length = right - left + 1;
        int j = log[length];
        return Math.min(sparseTable[left][j], sparseTable[right - (1 << j) + 1][j]);
    }

    // Helper function to compute log base 2
    private int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 7, 9, 11, 3, 5, 1, 0};
        RangeMinQuerySparseTable rmq = new RangeMinQuerySparseTable(input);
        
        System.out.println("Range Min Query (2, 8): " + rmq.rangeMinQuery(2, 8)); // Output: 1
        System.out.println("Range Min Query (0, 5): " + rmq.rangeMinQuery(0, 5)); // Output: 1
    }
}

