// Last updated: 9/5/2025, 3:49:19 PM
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    public static int LIS(int[] arr){
        int []dp = new int[arr.length];
        Arrays.fill(dp,1);
        for(int i=1;i<dp.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    int x = dp[j];
                    dp[i]=Math.max(dp[i],x+1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}