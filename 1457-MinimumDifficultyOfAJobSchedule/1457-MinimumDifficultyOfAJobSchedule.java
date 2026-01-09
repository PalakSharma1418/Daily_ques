// Last updated: 1/9/2026, 10:57:16 AM
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d) return -1;
        if(jobDifficulty.length==d) 
        {
            int s=0;
            for(int n:jobDifficulty){
                s+=n;
            }
            return s;
        }
        int[][] dp = new int[d + 1][jobDifficulty.length];//d+1 1....d 
        for (int i = 0; i <= d; i++) {
            Arrays.fill(dp[i], -1);
        }

        return func(jobDifficulty, d, 0, dp);
    }
    public static int func(int[] arr , int d , int start , int[][]dp ){
        int  n=arr.length;
        if (n - start < d) return Integer.MAX_VALUE;
        if(d==1){
            int max =0;
            for(int i=start;i<n;i++){
                max=Math.max(max,arr[i]);
            }
            return max;
        }
        
        if (dp[d][start] != -1) return dp[d][start];

        int ans= Integer.MAX_VALUE;
        int max=0;

        for (int i = start; i <= n - d; i++) {
            max = Math.max(max, arr[i]); // max for today
            int next = func(arr, d - 1, i + 1,dp); // next days
            ans = Math.min(ans, max + next);
        }
        return dp[d][start] = ans;

    }
}
// If I start at job index start with d days remaining,
// what is the minimum total difficulty from here to the end?