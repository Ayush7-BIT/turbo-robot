class RMQSquareRoot {
    private int[] arr;
    private int[] block;
    private int blockSize;

    public RMQSquareRoot(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        this.blockSize = (int) Math.sqrt(n);
        this.block = new int[(n + blockSize - 1) / blockSize];  // ceil(n / blockSize)
        preprocess();
    }

    // Preprocess the array to calculate minimum for each block
    private void preprocess() {
        int n = arr.length;
        for (int i = 0; i < block.length; i++) {
            block[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            block[i / blockSize] = Math.min(block[i / blockSize], arr[i]);
        }
    }

    // Query for minimum in range [l, r]
    public int query(int l, int r) {
        int min = Integer.MAX_VALUE;
        while (l <= r && l % blockSize != 0) {  // Left partial block
            min = Math.min(min, arr[l]);
            l++;
        }
        while (l + blockSize - 1 <= r) {  // Full blocks
            min = Math.min(min, block[l / blockSize]);
            l += blockSize;
        }
        while (l <= r) {  // Right partial block
            min = Math.min(min, arr[l]);
            l++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 4, 6, 1, 3, 5, 7, 2};
        RMQSquareRoot rmq = new RMQSquareRoot(arr);
        System.out.println("Min of [3, 8]: " + rmq.query(3, 8));  // Output: 1
        System.out.println("Min of [1, 6]: " + rmq.query(1, 6));  // Output: 1
    }
}
