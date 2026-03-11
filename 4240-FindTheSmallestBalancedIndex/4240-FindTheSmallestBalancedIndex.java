// Last updated: 3/11/2026, 8:00:16 PM
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length ;
        long[] right  = new long[n];
        right[n-1] = nums[n-1];
        for(int i= n-2 ; i>=0 ; i--){
            // right[i]= right[i+1]*nums[i];
            if(right[i+1] > Long.MAX_VALUE/nums[i]){
                right[i]=Long.MAX_VALUE;
            }
            else{
                right[i] = right[i+1]*nums[i];
            }
        }
        long leftSum = 0;
        for(int i=0 ; i<n ; i++){
            long rightProduct ;
            if(i==n-1){
                rightProduct = 1;
            }
            else{
                rightProduct = right[i+1];
            }
            if(leftSum==rightProduct) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}