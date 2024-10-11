// Java program to implement Kadane's Algorithm
public class KadanesAlgorithm {

    // Function to find the maximum sum of a contiguous subarray
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE; // To store the maximum sum so far
        int maxEndingHere = 0;            // To store the sum of the current subarray

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];

            // Update maxSoFar if maxEndingHere is greater
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // If maxEndingHere drops below 0, reset it to 0
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArraySum(arr);
        System.out.println("Maximum contiguous subarray sum is: " + maxSum);
    }
}
