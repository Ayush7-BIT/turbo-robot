/**
 * Longest Increasing Subsequence (LIS) using Dynamic Programming
 * 
 * This algorithm finds the length of the longest increasing subsequence (LIS)
 * in an array using dynamic programming.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Use Case: Common in optimization problems such as analyzing trends in stock prices, 
 * sequence alignment, or determining a progression of ordered tasks.
 */
public class LongestIncreasingSubsequence {

    /**
     * Finds the length of the longest increasing subsequence in an array of integers.
     * 
     * @param arr Input array of integers
     * @return The length of the longest increasing subsequence
     */
    public static int findLIS(int[] arr) {
        int n = arr.length;

        // Special case: If the array is empty, return 0
        if (n == 0) {
            return 0;
        }

        // dp[i] will store the length of the LIS ending at index i
        int[] dp = new int[n];

        // Each element can be its own subsequence of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // Initialize LIS length for each element as 1
        }

        // Build the dp array in a bottom-up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // If increasing, update dp[i]
                }
            }
        }

        // Find the maximum LIS length from the dp array
        int maxLIS = 1;  // Since the smallest subsequence length is 1
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        // Example test case: an array of integers
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        // Output the length of the longest increasing subsequence
        int lisLength = findLIS(arr);
        System.out.println("Length of Longest Increasing Subsequence is: " + lisLength);
    }
}
