// Last updated: 2/18/2026, 11:34:49 AM
class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long dp[] = new long[n+2];
        Arrays.fill(dp,-1);
        return solve(nums,colors,dp,0);
    }
    public static long solve(int[]nums , int[]colors , long dp[] , int i){
        int n=nums.length;
        if(i>=n) return 0;

        if(dp[i] !=-1) return dp[i];
        long s = solve(nums,colors,dp,i+1);
        //long j= nums[i]+solve(nums,colors,dp,i+2);
        long t = 0;
        long rob = nums[i];
        // if(i+1<n && colors[i]!=colors[i+1]){
        //     t = nums[i]+solve(nums,colors,dp,i);
        // }
        //return dp[i]=Math.max(s,Math.max(j,t));
        if(i+1<n){
            if(colors[i]!=colors[i+1]){
                rob+=solve(nums,colors,dp,i+1);
            }
            else{
                rob+=solve(nums,colors,dp,i+2);
            }
        }
        return dp[i]=Math.max(s,rob);
    }
}