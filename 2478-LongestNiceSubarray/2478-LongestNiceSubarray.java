// Last updated: 8/6/2025, 4:43:06 PM
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int usedbit=0;
        int maxlen=0;
        int start=0;
        for(int end=0;end<nums.length;end++){

            while((usedbit & nums[end] )!=0){
                usedbit ^=nums[start];
                start++;
            }
            usedbit |=nums[end];
            maxlen=Math.max(maxlen,end-start+1);
        }
        return maxlen;
    }
}