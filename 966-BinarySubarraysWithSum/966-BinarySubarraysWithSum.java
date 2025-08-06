// Last updated: 8/6/2025, 4:46:25 PM
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    public int atmost(int nums[],int k){
        int l=0,r=0;
        int c=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            // shrink
            while (sum > k && l <= r){
                sum-=nums[l];
                l++;
            }
            c+=(r-l)+1;
            r++;
        }
        return c;
    }
}