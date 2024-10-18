import java.util.Arrays;

public class RangeMinimumQuery {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 8, 2, 7, 9};

        // Square Root Decomposition
        RangeMinimumQuerySqrtDecomposition rmqs1 = new RangeMinimumQuerySqrtDecomposition(arr);
        int min1 = rmqs1.query(2, 6);
        System.out.println("Square Root Decomposition: Minimum value in range [2, 6] is: " + min1);

        // Sparse Table
        RangeMinimumQuerySparseTable rmqs2 = new RangeMinimumQuerySparseTable(arr);
        int min2 = rmqs2.query(2, 6);
        System.out.println("Sparse Table: Minimum value in range [2, 6] is: " + min2);
    }
}
