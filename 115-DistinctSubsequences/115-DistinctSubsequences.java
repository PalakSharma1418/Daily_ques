// Last updated: 9/8/2025, 7:39:48 PM
class Solution {
    // coinchange
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
         for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return c(s,t,0,0,dp);
        
    }
    // s--> coin t--> amount i-->s j-->t
    public static int c(String s, String t, int i, int j, int[][] dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int inc=0, exc=0;
        if(s.charAt(i) == t.charAt(j)){
            inc = c(s,t,i+1,j+1,dp);
        }
        exc=c(s,t,i+1,j,dp);
        return dp[i][j]= inc+exc;

    }
}