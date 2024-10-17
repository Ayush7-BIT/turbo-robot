//your code
class Solution {
    public void sortColors(int[] nums) {
        int mid=0, low=0, high=nums.length-1;

        while(mid <= high){
            if (nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;

                high--;
            }

            else if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;

                low++; mid++;
            }

            else{
                mid++;
            }
        }
    }
}

//driver code
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        System.out.println("Before sorting: " + Arrays.toString(nums1));
        solution.sortColors(nums1);
        System.out.println("After sorting: " + Arrays.toString(nums1));
      
        int[] nums2 = {2, 2, 1, 0, 1, 0};
        System.out.println("Before sorting: " + Arrays.toString(nums2));
        solution.sortColors(nums2);
        System.out.println("After sorting: " + Arrays.toString(nums2));
