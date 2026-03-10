// Last updated: 3/10/2026, 11:46:31 AM
1class Solution {
2
3    int[][] dir = {
4        {-2,-1},{-1,-2},{1,-2},{2,-1},
5        {2,1},{1,2},{-1,2},{-2,1}
6    };
7
8    double[][][] dp;
9
10    public double knightProbability(int n, int k, int row, int column) {
11
12        dp = new double[k+1][n][n];
13
14        for(int i=0;i<=k;i++)
15            for(int j=0;j<n;j++)
16                Arrays.fill(dp[i][j], -1);
17
18        return solve(n,k,row,column);
19    }
20
21    public double solve(int n,int k,int r,int c){
22
23        if(r<0 || c<0 || r>=n || c>=n)
24            return 0;
25
26        if(k==0)
27            return 1;
28
29        if(dp[k][r][c] != -1)
30            return dp[k][r][c];
31
32        double prob = 0;
33
34        for(int[] d:dir){
35
36            int nr = r + d[0];
37            int nc = c + d[1];
38
39            prob += solve(n,k-1,nr,nc) / 8.0;
40        }
41
42        return dp[k][r][c] = prob;
43    }
44}