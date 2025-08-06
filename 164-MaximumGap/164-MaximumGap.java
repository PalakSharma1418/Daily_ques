// Last updated: 8/6/2025, 4:49:28 PM
class Solution {
      public int maximumGap(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        Arrays.sort(nums);
        int d=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>d){ //Math.abs
                d=nums[i+1]-nums[i];
            }
        }
        return d;
    }
}