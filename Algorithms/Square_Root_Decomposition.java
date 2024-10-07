import java.util.Arrays;

public class SquareRootDecomposition {
    private int[] arr;
    private int[] blockMins;
    private int blockSize;
    
    public SquareRootDecomposition(int[] input) {
        this.arr = input.clone();
        this.blockSize = (int) Math.sqrt(input.length);
        int numBlocks = (int) Math.ceil((double) input.length / blockSize);
        this.blockMins = new int[numBlocks];
        Arrays.fill(blockMins, Integer.MAX_VALUE);
        
        for (int i = 0; i < input.length; i++) {
            int blockIndex = i / blockSize;
            blockMins[blockIndex] = Math.min(blockMins[blockIndex], input[i]);
        }
    }
    
    public int query(int left, int right) {
        int minVal = Integer.MAX_VALUE;
        
        while (left <= right && left % blockSize != 0) {
            minVal = Math.min(minVal, arr[left]);
            left++;
        }
        
        while (left + blockSize - 1 <= right) {
            int blockIndex = left / blockSize;
            minVal = Math.min(minVal, blockMins[blockIndex]);
            left += blockSize;
        }
        
        while (left <= right) {
            minVal = Math.min(minVal, arr[left]);
            left++;
        }
        
        return minVal;
    }
    
    public static void main(String[] args) {
        int[] input = {1, 4, 2, 7, 9, 5, 3, 7, 0, 6};
        SquareRootDecomposition rmq = new SquareRootDecomposition(input);
        System.out.println(rmq.query(1, 7)); 
    }
}
