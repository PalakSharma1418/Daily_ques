// Last updated: 10/6/2025, 7:46:59 PM
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