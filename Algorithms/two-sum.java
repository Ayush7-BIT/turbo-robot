class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int find=target-nums[i];
            if(hm.containsKey(find)){
                int [] arr={hm.get(find),i};
                 return arr;
            }
            hm.put(nums[i],i);
        }
        return null;
    }
}
