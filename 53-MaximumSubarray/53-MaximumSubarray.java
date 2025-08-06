// Last updated: 8/6/2025, 4:50:48 PM
class Solution {
    public int maxSubArray(int[] nums) {
        return maximum_sum(nums);
    }
     public static int maximum_sum(int [] arr){
        int ans= Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            ans= Math.max(ans, sum);
            if(sum<0){
                sum=0;
            }
        }
        return ans;

    }
}