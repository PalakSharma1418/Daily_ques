// Last updated: 1/9/2026, 10:57:24 AM
class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[][]= new int[nums.length][3];
        for(int n[]:dp){
            Arrays.fill(n,-1);
        }
        return function(nums,0,0,dp);
    }
    public static int function(int[]arr , int i , int rem, int[][]dp){
        if(i==arr.length){
            return rem==0?0:Integer.MIN_VALUE;
        }
        if(dp[i][rem]!=-1){
            return dp[i][rem];
        }
        int nr = (rem+arr[i])%3;
        int pick = arr[i]+ function(arr,i+1,nr ,dp);
        int np= function(arr,i+1,rem, dp);
        return dp[i][rem]= Math.max(pick ,np);
    }
}