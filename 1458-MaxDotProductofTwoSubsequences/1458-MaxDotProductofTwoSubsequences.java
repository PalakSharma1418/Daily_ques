// Last updated: 1/8/2026, 6:33:21 PM
1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3        int[][] dp=new int[nums1.length][nums2.length];
4        int an=maxprod(nums1,nums2,0,0,dp);
5        return an;   
6    }
7    public int maxprod(int[] nums1,int[] nums2,int i,int j,int[][] dp){
8        if(i==nums1.length||j==nums2.length){
9            return Integer.MIN_VALUE;
10        }
11        if(dp[i][j]!=0){
12            return dp[i][j];
13        }
14        int cur=nums1[i]*nums2[j];
15        int p1=maxprod(nums1,nums2,i+1,j+1,dp);
16        if(p1>0){
17            cur+=p1;
18        }
19        int p2=maxprod(nums1,nums2,i+1,j,dp);
20        int p3=maxprod(nums1,nums2,i,j+1,dp);
21        return dp[i][j]=Math.max(cur,Math.max(p2,p3));
22    }
23}