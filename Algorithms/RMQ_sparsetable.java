import java.util.Scanner;

class SparseTable {
    int[][] sparseTable;
    int[] log;
    int n;

    public SparseTable(int[] arr) {
        n = arr.length;
        int maxLog = (int) (Math.log(n) / Math.log(2)) + 1;
        sparseTable = new int[n][maxLog];
        log = new int[n + 1];

        log[1] = 0;
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }

        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                sparseTable[i][j] = Math.min(sparseTable[i][j - 1], sparseTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    public int rangeMinQuery(int l, int r) {
        int j = log[r - l + 1];
        return Math.min(sparseTable[l][j], sparseTable[r - (1 << j) + 1][j]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build Sparse Table
        SparseTable sparseTable = new SparseTable(arr);

        // Input number of queries
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {
            System.out.println("Enter range (l, r): ");
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Output the minimum in range [l, r]
            System.out.println("Range Minimum (" + l + ", " + r + "): " + sparseTable.rangeMinQuery(l, r));
        }

        sc.close();
    }
}
