// Last updated: 8/6/2025, 4:47:13 PM
class Solution {
    public boolean checkPossibility(int[] nums) {
        int c=0,n=nums.length;
        for(int i=0;i <= n - 2;i++){
            if(nums[i]>nums[i+1]){
                c++;
                if(c>1){
                    return false;
                }
                 if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];  // lower current
                } else {
                    nums[i + 1] = nums[i];  // raise next
                }
            }
        }
        return true;
    }
}