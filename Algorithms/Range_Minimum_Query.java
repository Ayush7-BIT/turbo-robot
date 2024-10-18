import java.util.Arrays;

class RangeMinimumQuerySQRT {
    int[] arr, blocks;
    int blockSize;

    public RangeMinimumQuerySQRT(int[] input) {
        arr = input;
        blockSize = (int) Math.sqrt(arr.length);
        blocks = new int[(arr.length + blockSize - 1) / blockSize];
        Arrays.fill(blocks, Integer.MAX_VALUE);

        // Preprocess blocks
        for (int i = 0; i < arr.length; i++) {
            blocks[i / blockSize] = Math.min(blocks[i / blockSize], arr[i]);
        }
    }

    // Function to query minimum in range [l, r]
    public int query(int l, int r) {
        int min = Integer.MAX_VALUE;

        // Traverse the left part
        while (l <= r && l % blockSize != 0) {
            min = Math.min(min, arr[l]);
            l++;
        }

        // Traverse the block part
        while (l + blockSize <= r) {
            min = Math.min(min, blocks[l / blockSize]);
            l += blockSize;
        }

        // Traverse the right part
        while (l <= r) {
            min = Math.min(min, arr[l]);
            l++;
        }

        return min;
    }

    // Update function
    public void update(int index, int value) {
        arr[index] = value;
        int blockIndex = index / blockSize;
        blocks[blockIndex] = Integer.MAX_VALUE;

        // Update the block
        for (int i = blockIndex * blockSize; i < Math.min((blockIndex + 1) * blockSize, arr.length); i++) {
            blocks[blockIndex] = Math.min(blocks[blockIndex], arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 7, 9, 11, 3, 5, 8};
        RangeMinimumQuerySQRT rmq = new RangeMinimumQuerySQRT(input);

        System.out.println("Minimum of range (1, 6): " + rmq.query(1, 6));
        rmq.update(3, 0);  // Update index 3 to value 0
        System.out.println("Minimum of range (1, 6) after update: " + rmq.query(1, 6));
    }
}
