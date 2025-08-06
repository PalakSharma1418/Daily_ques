// Last updated: 8/6/2025, 4:44:54 PM
class Solution {
    public boolean check(int[] nums) {
        int n= nums.length;
        int b=0;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                b++;
            }
        }
        if(nums[0]<nums[n-1]){
            b++;
        }
        return b<=1;
    }
}