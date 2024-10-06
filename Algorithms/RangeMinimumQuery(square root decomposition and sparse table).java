//Implements the Range Minimum Query (RMQ) using two techniques: Square Root Decomposition and Sparse Table.
public class RangeMinimumQuery {

    static int[] block;
    static int bSize;
    static int[][] sTable;

    public static void preprocessSqrt(int[] arr, int n) {
        bSize = (int) Math.sqrt(n);
        block = new int[(n + bSize - 1) / bSize];

        for (int i = 0; i < block.length; i++) {
            block[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            block[i / bSize] = Math.min(block[i / bSize], arr[i]);
        }
    }

    public static int querySqrt(int[] arr, int l, int r) {
        if (l < 0 || r >= arr.length || l > r) {
            System.out.println("Invalid query range");
            return -1;
        }

        int min = Integer.MAX_VALUE;

        while (l <= r && l % bSize != 0) {
            min = Math.min(min, arr[l]);
            l++;
        }

        while (l + bSize - 1 <= r) {
            min = Math.min(min, block[l / bSize]);
            l += bSize;
        }

        while (l <= r) {
            min = Math.min(min, arr[l]);
            l++;
        }

        return min;
    }

    public static void preprocessSparse(int[] arr, int n) {
        int log = (int) Math.floor(Math.log(n) / Math.log(2)) + 1; // Correct log calculation
        sTable = new int[n][log];

        for (int i = 0; i < n; i++) {
            sTable[i][0] = arr[i];
        }

        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; (i + (1 << j)) <= n; i++) {
                sTable[i][j] = Math.min(sTable[i][j - 1], sTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public static int querySparse(int l, int r) {
        if (l < 0 || r >= sTable.length || l > r) {
            System.out.println("Invalid query range");
            return -1;
        }

        int log = (int) Math.floor(Math.log(r - l + 1) / Math.log(2));
        return Math.min(sTable[l][log], sTable[r - (1 << log) + 1][log]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 3, 5, 6, 8};
        int n = arr.length;

        preprocessSqrt(arr, n);
        System.out.println("Square Root Decomposition:");
        System.out.println("Min in range (1, 5): " + querySqrt(arr, 1, 5));
        System.out.println("Min in range (0, 3): " + querySqrt(arr, 0, 3));
        System.out.println("Min in range (7, 9): " + querySqrt(arr, 7, 9));
        System.out.println("Min in range (2, 10): " + querySqrt(arr, 2, 10));

        preprocessSparse(arr, n);
        System.out.println("Sparse Table:");
        System.out.println("Min in range (1, 5): " + querySparse(1, 5));
        System.out.println("Min in range (0, 3): " + querySparse(0, 3));
        System.out.println("Min in range (7, 9): " + querySparse(7, 9));
        System.out.println("Min in range (2, 10): " + querySparse(2, 10));
    }
}
