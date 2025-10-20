// Last updated: 10/20/2025, 8:07:25 PM
class Solution {
    public int numSquares(int n) {
        int dp []= new int[n+1];
        Arrays.fill(dp,-1);
        return num(n,dp);
    }
     public int num(int n, int[] dp) {
        if(n == 0) return 0; // no squares needed for 0
        if(dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + num(n - i*i, dp));
        }

        return dp[n] = ans;
    }
}
    // public int num(int n, int c,int dp[]) {
    //     if(n==0) return c;
    //     int ans = Integer.MAX_VALUE;
    //     if(dp[n]!=-1) return dp[n]+c;
    //     for(int i=1;i*i<=n;i++){
    //         int s = num(n-(i*i),c+1,dp);
    //         ans=Math.min(s,ans);
    //     }
    //     return dp[n]= ans-c;
    // }
// You are on level n and have already taken c steps.
// Your notebook says you need 2 more steps from here (dp[n]=2).
// So total = what you already did (c) + what’s left (dp[n]).
// When you first write in your notebook, you don’t write how many you already took — so you subtract that (-c).