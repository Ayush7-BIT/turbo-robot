import java.util.Arrays;

class SqrtDecompositionRMQ {

    // Array to store the input values
    static int[] arr;
    
    // Array to store the minimum of each block
    static int[] blockMin;
    
    // Size of each block
    static int blockSize; 

    /**
     * Build the square root decomposition structure for RMQ.
     * This preprocesses the array to create blocks with minimum values.
     * Preprocessing Time: O(n)
     * @param arr The input array
     * @param n The length of the input array
     */
    static void buildSqrtDecomposition(int[] arr, int n) {
        // Determine the size of each block (sqrt of the array length)
        blockSize = (int) Math.sqrt(n);
        
        // Create an array for storing the minimum values of each block
        blockMin = new int[(n + blockSize - 1) / blockSize]; // ceiling(n / blockSize)
        
        // Initialize blockMin with a large value
        Arrays.fill(blockMin, Integer.MAX_VALUE);

        // Fill blockMin array with the minimum value in each block
        for (int i = 0; i < n; i++) {
            int block = i / blockSize;  // Determine which block the current element belongs to
            blockMin[block] = Math.min(blockMin[block], arr[i]);  // Update the minimum of the block
        }
    }

    /**
     * Answer a Range Minimum Query (RMQ) using the square root decomposition structure.
     * Query Time: O(sqrt(n))
     * @param L The left index of the range
     * @param R The right index of the range
     * @return The minimum value in the range arr[L..R]
     */
    static int querySqrtDecomposition(int L, int R) {
        int minVal = Integer.MAX_VALUE; // Variable to store the minimum value found in the range

        // Process elements in the left partial block
        while (L <= R && L % blockSize != 0) {
            minVal = Math.min(minVal, arr[L]);
            L++;
        }

        // Process complete blocks in the middle of the range
        while (L + blockSize - 1 <= R) {
            int block = L / blockSize;  // Determine the block index
            minVal = Math.min(minVal, blockMin[block]);  // Compare the minimum value of the block
            L += blockSize;  // Move to the next block
        }

        // Process elements in the right partial block
        while (L <= R) {
            minVal = Math.min(minVal, arr[L]);
            L++;
        }

        return minVal;
    }

    // Driver method to test the implementation
    public static void main(String[] args) {
        arr = new int[]{7, 2, 3, 0, 5, 10, 3, 12, 18};
        int n = arr.length;

        // Build the square root decomposition structure
        buildSqrtDecomposition(arr, n);

        // Queries for the range minimum in various ranges
        System.out.println("Queries using Square Root Decomposition:");
        System.out.println("Minimum in range [0, 4]: " + querySqrtDecomposition(0, 4));  // Output: 0
        System.out.println("Minimum in range [4, 7]: " + querySqrtDecomposition(4, 7));  // Output: 3
        System.out.println("Minimum in range [7, 8]: " + querySqrtDecomposition(7, 8));  // Output: 12
    }
}
