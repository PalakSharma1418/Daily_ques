// Last updated: 8/6/2025, 4:41:54 PM
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]%2!=0 && nums[i+1]%2!=0){
                return false;
            }
            else if(nums[i]%2==0 && nums[i+1]%2==0){
                return false;
            }
        }
        return true;
    }
}