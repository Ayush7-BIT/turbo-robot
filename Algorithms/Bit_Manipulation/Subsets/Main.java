package Algorithms.Bit_Manipulation.Subsets;

// Leetcode 78 - Subsets

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> subsets(int[] nums){
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
            list1.add(list2);
        }

        return list1;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1, 2, 3});
        System.out.println(res);
    }
}

