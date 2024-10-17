// your code
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int high=m*n-1, low=0;

        while(low <= high){
            int mid=(low + high)/2;

            if(matrix[mid/n][mid%n] == target){
               return true;
            }
            else if(matrix[mid/n][mid%n] > target){
                high=mid-1;
            }
            else {
               low=mid+1;
            }
        }
        return false;
    }
}

//main code
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Test case 1: " + solution.searchMatrix(matrix1, target1)); 

        // Test case 2
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Test case 2: " + solution.searchMatrix(matrix2, target2));  

        // Test case 3 (edge case with single element matrix)
        int[][] matrix3 = {
            {10}
        };
        int target3 = 10;
        System.out.println("Test case 3: " + solution.searchMatrix(matrix3, target3)); 
    }
}
