//Add code for Range Minimum Query (Square Root Decomposition and Sparse Table) in Java #2
import java.util.Arrays;

public class RMQSquareRootDecomposition {
    int[] arr;
    int[] block;
    int blockSize;

    // Constructor to initialize the array and block structure
    public RMQSquareRootDecomposition(int[] input) {
        this.arr = input;
        this.blockSize = (int) Math.sqrt(arr.length);
        this.block = new int[(arr.length + blockSize - 1) / blockSize];
        preprocess();
    }

    // Preprocess array to fill block array with minimum values
    private void preprocess() {
        Arrays.fill(block, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            block[i / blockSize] = Math.min(block[i / blockSize], arr[i]);
        }
    }

    // Function to query the minimum value in the range [L, R]
    public int query(int L, int R) {
        int min = Integer.MAX_VALUE;

        // Traverse first block in the range
        while (L < R && L % blockSize != 0 && L != 0) {
            min = Math.min(min, arr[L]);
            L++;
        }

        // Traverse complete blocks in the range
        while (L + blockSize <= R) {
            min = Math.min(min, block[L / blockSize]);
            L += blockSize;
        }

        // Traverse the last block in the range
        while (L <= R) {
            min = Math.min(min, arr[L]);
            L++;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 3, 5, 8, 12};
        RMQSquareRootDecomposition rmq = new RMQSquareRootDecomposition(arr);

        System.out.println("Min between (1, 6): " + rmq.query(1, 6)); // Output: 2
        System.out.println("Min between (3, 9): " + rmq.query(3, 9)); // Output: 3
    }
}
