// Last updated: 8/6/2025, 4:47:09 PM
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0,p=1;
        int si=0,ei=0;
        while( ei<nums.length){
            //grow
            p=p*nums[ei];
            //shrink
            while(si<=ei && p>=k){
                p=p/nums[si];
                si++;
            }
            // ans update
            ans=ans+(ei-si+1);
            ei++;
        }
        return ans;
    }
}