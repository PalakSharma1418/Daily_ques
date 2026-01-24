// Last updated: 1/24/2026, 5:54:10 PM
1class Solution {
2
3    int[][] dp;
4    public int minimizeTheDifference(int[][] mat, int target) {
5        dp=new int[mat.length][4901];
6        for(int i=0;i<mat.length;i++) Arrays.fill(dp[i],-1);
7        return dfs(mat,0,target,0);
8    }
9    public int dfs(int[][] mat,int index,int target,int sum){
10        if(index==mat.length){
11            return Math.abs(sum-target);
12        }
13        if(dp[index][sum]!=-1) return dp[index][sum];
14        int ans=Integer.MAX_VALUE;
15        for(int i=0;i<mat[0].length;i++){
16            ans=Math.min(ans,dfs(mat,index+1,target,sum+mat[index][i]));
17        }
18        dp[index][sum]=ans;
19        return ans;
20    }
21}