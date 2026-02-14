// Last updated: 2/14/2026, 8:38:20 PM
1class Solution {
2    public long rob(int[] nums, int[] colors) {
3        int n = nums.length;
4        long dp[] = new long[n+2];
5        Arrays.fill(dp,-1);
6        return solve(nums,colors,dp,0);
7    }
8    public static long solve(int[]nums , int[]colors , long dp[] , int i){
9        int n=nums.length;
10        if(i>=n) return 0;
11
12        if(dp[i] !=-1) return dp[i];
13        long s = solve(nums,colors,dp,i+1);
14        //long j= nums[i]+solve(nums,colors,dp,i+2);
15        long t = 0;
16        long rob = nums[i];
17        // if(i+1<n && colors[i]!=colors[i+1]){
18        //     t = nums[i]+solve(nums,colors,dp,i);
19        // }
20        //return dp[i]=Math.max(s,Math.max(j,t));
21        if(i+1<n){
22            if(colors[i]!=colors[i+1]){
23                rob+=solve(nums,colors,dp,i+1);
24            }
25            else{
26                rob+=solve(nums,colors,dp,i+2);
27            }
28        }
29        return dp[i]=Math.max(s,rob);
30    }
31}