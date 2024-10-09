import java.util.Arrays;

public class RangeMinimumQuery {

    // Define the maximum possible array size
    private static final int MAX = 500;
    private int[][] minTable;

    // Constructor to initialize and preprocess the array
    public RangeMinimumQuery(int[] arr) {
        int n = arr.length;
        minTable = new int[n][n];
        preprocess(arr, n);
    }

    // Method to preprocess the array and fill the lookup table
    private void preprocess(int[] arr, int n) {
        // Initialize the diagonal of the table (single element ranges)
        for (int i = 0; i < n; i++) {
            minTable[i][i] = i;
        }

        // Fill the table for ranges larger than 1 element
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compare the current element with the minimum of the previous range
                if (arr[minTable[i][j - 1]] < arr[j]) {
                    minTable[i][j] = minTable[i][j - 1];
                } else {
                    minTable[i][j] = j;
                }
            }
        }
    }

    // Method to answer RMQ queries in O(1) time
    public int query(int[] arr, int left, int right) {
        return arr[minTable[left][right]];
    }

    // Driver code to test the RMQ implementation
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        RangeMinimumQuery rmq = new RangeMinimumQuery(arr);

        // Define query ranges
        int[][] queries = {{0, 4}, {4, 7}, {7, 8}};

        // Execute each query and print the result
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            System.out.println("Minimum value in range [" + left + ", " + right + "] is: "
                    + rmq.query(arr, left, right));
        }
    }
}
