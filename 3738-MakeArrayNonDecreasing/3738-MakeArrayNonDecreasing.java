// Last updated: 8/6/2025, 4:41:24 PM
class Solution {
    public int maximumPossibleSize(int[] nums) {
        int prev= nums[0];
        int c=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>= prev){
                c++;
                prev=nums[i];
            }
        }
        return c;
    }
}