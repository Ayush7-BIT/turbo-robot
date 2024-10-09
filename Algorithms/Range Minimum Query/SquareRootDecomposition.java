import java.util.Arrays;

public class RMQSquareRoot {
    private int[] arr;
    private int[] block;
    private int blockSize;

    public RMQSquareRoot(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        blockSize = (int) Math.sqrt(n);
        block = new int[(n + blockSize - 1) / blockSize];
        Arrays.fill(block, Integer.MAX_VALUE);
        preprocess();
    }

    private void preprocess() {
        for (int i = 0; i < arr.length; i++) {
            int blockIndex = i / blockSize;
            block[blockIndex] = Math.min(block[blockIndex], arr[i]);
        }
    }

    public int query(int l, int r) {
        int min = Integer.MAX_VALUE;
        while (l < r && l % blockSize != 0) {
            min = Math.min(min, arr[l]);
            l++;
        }
        while (l + blockSize <= r) {
            min = Math.min(min, block[l / blockSize]);
            l += blockSize;
        }
        while (l <= r) {
            min = Math.min(min, arr[l]);
            l++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 3, 5, 6, 4};
        RMQSquareRoot rmq = new RMQSquareRoot(arr);
        System.out.println("Minimum value between indices 1 and 5: " + rmq.query(1, 5));
        System.out.println("Minimum value between indices 4 and 9: " + rmq.query(4, 9));
    }
}
