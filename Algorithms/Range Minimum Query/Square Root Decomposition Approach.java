import java.util.Arrays;

class RMQSquareRoot {
    int[] array;
    int[] minBlock;
    int blkSize;

    // Constructor to preprocess the array for Square Root Decomposition
    public RMQSquareRoot(int[] array) {
        this.array = array;
        int n = array.length;
        blkSize = (int) Math.sqrt(n);  // Define block size based on array length
        minBlock = new int[(n + blkSize - 1) / blkSize];  // Initialize block minimums
        
        // Initialize each block with the maximum possible value
        Arrays.fill(minBlock, Integer.MAX_VALUE);
        
        // Preprocess the blocks to store the minimum value for each block
        for (int i = 0; i < n; i++) {
            minBlock[i / blkSize] = Math.min(minBlock[i / blkSize], array[i]);
        }
    }

    // Query method to get the minimum element in the range [left, right]
    public int getRangeMin(int left, int right) {
        int minVal = Integer.MAX_VALUE;

        // Traverse left part (before first fully-covered block)
        while (left <= right && left % blkSize != 0) {
            minVal = Math.min(minVal, array[left]);
            left++;
        }

        // Traverse fully-covered blocks in the middle
        while (left + blkSize - 1 <= right) {
            minVal = Math.min(minVal, minBlock[left / blkSize]);
            left += blkSize;
        }

        // Traverse right part (after last fully-covered block)
        while (left <= right) {
            minVal = Math.min(minVal, array[left]);
            left++;
        }

        return minVal;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 1, 9, 12, 6, 8, 5, 11};
        RMQSquareRoot rmq = new RMQSquareRoot(arr);

        // Query the minimum value in the range [2, 8]
        System.out.println(rmq.getRangeMin(2, 8));  // Output: 1
    }
}