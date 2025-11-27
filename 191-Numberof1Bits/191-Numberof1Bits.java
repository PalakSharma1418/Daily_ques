// Last updated: 11/27/2025, 12:32:08 PM
1class Solution {
2    public int hammingWeight(int n) {
3        int ans=0;
4        while(n>0){
5            n=n&(n-1);
6            ans++;
7        }
8        return ans;
9    }
10}