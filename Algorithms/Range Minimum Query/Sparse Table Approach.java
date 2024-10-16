class RMQSparseTable {
    int[][] table;
    int[] logValues;
    int n;

    public RMQSparseTable(int[] array) {
        this.n = array.length;
        logValues = new int[n + 1];
        table = new int[n][(int) (Math.log(n) / Math.log(2)) + 1];

        for (int i = 2; i <= n; i++) logValues[i] = logValues[i / 2] + 1;


        // Initialize the Sparse Table's base case with array values
        for (int i = 0; i < n; i++) table[i][0] = array[i];

        // Fill the rest of the Sparse Table using dynamic programming
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                table[i][j] = Math.min(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // Query method to get the minimum value in the range [left, right]
    public int getRangeMin(int left, int right) {
        int rangeLog = logValues[right - left + 1];
        return Math.min(table[left][rangeLog], table[right - (1 << rangeLog) + 1][rangeLog]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 9, 3, 8};
        RMQSparseTable rmq = new RMQSparseTable(arr);

        // Query the minimum value in the range [1, 5]
        System.out.println(rmq.getRangeMin(1, 5));  // Output: 1
    }
}