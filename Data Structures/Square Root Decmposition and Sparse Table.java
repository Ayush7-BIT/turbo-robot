public class RangeMinimumQuery {

    // Square Root Decomposition
    static class SquareRootDecomposition {
        private int[] arr;
        private int[] blockMins;
        private int blockSize;

        public SquareRootDecomposition(int[] arr) {
            this.arr = arr;
            int n = arr.length;
            blockSize = (int) Math.sqrt(n);
            int numBlocks = (n + blockSize - 1) / blockSize;
            blockMins = new int[numBlocks];

            for (int i = 0; i < numBlocks; i++) {
                int blockStart = i * blockSize;
                int blockEnd = Math.min(blockStart + blockSize, n);
                blockMins[i] = arr[blockStart];

                for (int j = blockStart + 1; j < blockEnd; j++) {
                    blockMins[i] = Math.min(blockMins[i], arr[j]);
                }
            }
        }

        public int rangeMinQuery(int left, int right) {
            int min = Integer.MAX_VALUE;
            int blockStart = left / blockSize;
            int blockEnd = right / blockSize;

            if (blockStart == blockEnd) {
                for (int i = left; i <= right; i++) {
                    min = Math.min(min, arr[i]);
                }
            } else {
                // Left block
                for (int i = left; i < (blockStart + 1) * blockSize && i < arr.length; i++) {
                    min = Math.min(min, arr[i]);
                }

                // Middle blocks
                for (int i = blockStart + 1; i < blockEnd; i++) {
                    min = Math.min(min, blockMins[i]);
                }

                // Right block
                for (int i = blockEnd * blockSize; i <= right && i < arr.length; i++) {
                    min = Math.min(min, arr[i]);
                }
            }

            return min;
        }
    }

    // Sparse Table
    static class SparseTable {
        private int[][] st;
        private int[] log;

        public SparseTable(int[] arr) {
            int n = arr.length;
            int logN = (int) (Math.log(n) / Math.log(2)) + 1;
            st = new int[n][logN];
            log = new int[n + 1];

            // Precomputing log values
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }

            // Initialize Sparse Table
            for (int i = 0; i < n; i++) {
                st[i][0] = arr[i];
            }

            // Build the Sparse Table
            for (int j = 1; (1 << j) <= n; j++) {
                for (int i = 0; i + (1 << j) - 1 < n; i++) {
                    st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        public int rangeMinQuery(int left, int right) {
            int j = log[right - left + 1];
            return Math.min(st[left][j], st[right - (1 << j) + 1][j]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11};

        // Square Root Decomposition
        SquareRootDecomposition sqrtRMQ = new SquareRootDecomposition(arr);
        System.out.println("Square Root Decomposition RMQ (1, 4): " + sqrtRMQ.rangeMinQuery(1, 4));

        // Sparse Table
        SparseTable sparseTable = new SparseTable(arr);
        System.out.println("Sparse Table RMQ (1, 4): " + sparseTable.rangeMinQuery(1, 4));
    }
}
