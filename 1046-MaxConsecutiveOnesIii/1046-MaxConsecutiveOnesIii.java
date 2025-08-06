// Last updated: 8/6/2025, 4:46:09 PM
class Solution {
    public int longestOnes(int[] nums, int k) {
        int si=0,ei=0,flip=0,ans=0;
        while(ei<nums.length){
            //grow
            if(nums[ei]==0){
                flip++;
            }
            //shrink
            while(flip>k && si<=ei){
                if(nums[si]==0){
                    flip--;
                }
                si++;
            }
            //ans update
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}