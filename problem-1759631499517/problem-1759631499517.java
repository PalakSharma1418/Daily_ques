// Last updated: 10/5/2025, 8:01:39 AM
class Solution {
    public int alternatingSum(int[] nums) {
        int ev=0,od=0;
        for(int i=0;i<nums.length;i++){
            if(i%2!=0) od+=nums[i];
            else ev+=nums[i];
        }
        return ev-od;
    }
}