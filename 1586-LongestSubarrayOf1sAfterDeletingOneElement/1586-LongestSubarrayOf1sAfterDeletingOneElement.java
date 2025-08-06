// Last updated: 8/6/2025, 4:45:24 PM
class Solution {
    public int longestSubarray(int[] nums) {
        int l=0,r=0;
        int n= nums.length;
        int f=0;
        int total=-1;
        while( r<n ){
            if(nums[r]==0) f++;
            // shrink
            while(f>1 && l<=r){
                if(nums[l]==0){
                    f--;
                }
                l++;
            }
            // res
            int ans= (r-l);
            total=Math.max(ans,total);
            r++;
        }
        return total;
    }
}