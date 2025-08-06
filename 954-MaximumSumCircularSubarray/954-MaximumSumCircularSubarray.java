// Last updated: 8/6/2025, 4:46:30 PM
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        for(int i:nums){
            total+=i;
        }
        int min= kad_min(nums);
        int max= kad_max(nums);
        if(total == min){
            return max;
        }
        // cicular sum--> total-minSum;
        int cSum=total-min;
        
        //  compare cSum and kadane's max sum and return the greater
        return Math.max(cSum,max);
        
    }
    public int kad_min(int[] arr){
        int minSum=Integer.MAX_VALUE;
        int min=0;
        for(int i: arr){
            min=min+i;
            minSum= Math.min(min,minSum);
            if(min>0){
                min=0;
            }
        }
        return minSum;
    }
    public int kad_max(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int max=0;
        for(int i: arr){
            max=max+i;
            maxSum= Math.max(max,maxSum);
            if(max<0){
                max=0;
            }
        }
        return maxSum;
    }
}