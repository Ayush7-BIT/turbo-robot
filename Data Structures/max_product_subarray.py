class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        maxc=nums[0]
        max1=nums[-1]
        pro=1
        pro1=1
        for i in range(len(nums)):
            if nums[i]==0:
                pro=pro*nums[i]
                pro1=pro1*nums[i]
                maxc=max(maxc,max(pro,pro1))
                pro=1
                pro1=1
                continue
            pro=pro*nums[i]
            pro1=pro1*nums[i]
            maxc=max(maxc,max(pro,pro1))
            if pro1<=0:
                pro1=1
        pro=1
        pro1=1
        for i in range(len(nums)-1,-1,-1):
            if nums[i]==0:
                pro=1
                pro1=1
                continue
            pro=pro*nums[i]
            pro1=pro1*nums[i]
            max1=max(max1,max(pro,pro1))
            if pro1<=0:
                pro1=1
        return max(max1,maxc)