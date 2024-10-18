package Algorithms.Bit_Manipulation.Subsets_II;

// Leetcode  90 - Subsets II
// Here array should be sorted otherwise [2,1] and [1,2] will be compared, and it will be treated as different elements
// If the array is sorted then [2,1] and [2,1] will be compared.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<List<Integer>> subsets(int[] nums){
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list1 = new ArrayList<>();
        int length = nums.length;
        for(int i = 0; i < (1 << length); i++){
            List<Integer> list2 = new ArrayList<>();
            int digits = (int) (Math.log(i) / Math.log(2)) + 1;
            for(int j = 0; j < digits; j++){
                if((i & (1 << j)) != 0){
                    list2.add(nums[j]);
                }
            }
            if (!list1.contains(list2)){
                list1.add(list2);
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{2,1,2});
        System.out.println(res);
    }
}
