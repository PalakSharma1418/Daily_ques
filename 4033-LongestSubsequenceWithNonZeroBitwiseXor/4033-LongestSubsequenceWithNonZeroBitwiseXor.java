// Last updated: 10/6/2025, 7:46:57 PM
class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean allzero=true;
        for(int n:nums){
            if(n!=0) allzero=false;
            xor^=n;
        }
        if(allzero) return 0;
        if(xor==0) return nums.length-1;
        return nums.length;
    }
}