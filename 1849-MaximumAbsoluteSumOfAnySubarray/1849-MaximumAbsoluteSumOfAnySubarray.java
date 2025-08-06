// Last updated: 8/6/2025, 4:44:57 PM
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            
            max = Math.max(sum, max);
        }
        
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum > 0){
                sum = 0;
            }
            sum += nums[i];
            
            min = Math.min(sum, min);
        }
        
        return Math.max(max, Math.abs(min));
    }
}
