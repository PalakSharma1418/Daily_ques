// Last updated: 8/6/2025, 4:49:09 PM
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int ans=Integer.MAX_VALUE;
       int sum=0,si=0,ei=0;
       while(ei<nums.length){
        //grow
        sum+=nums[ei];
        while(sum>=target){//
            ans=Math.min(ans,ei-si+1);
            sum-=nums[si];
            si++;
        }
        ei++;
       }
       return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}