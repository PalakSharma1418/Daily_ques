// Last updated: 12/21/2025, 11:46:37 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int dp[][]= new int[word1.length()][word2.length()];
4        for(int i=0;i<word1.length();i++){
5            Arrays.fill(dp[i],-1);
6        }
7        return edit(word1, word2, 0, 0, dp);
8    }
9
10    public static int edit(String s1, String s2, int i, int j, int[][] dp) {
11        // Base cases
12        if(i == s1.length()) return s2.length() - j; // insert remaining of s2 mtlb s1 choti hai ab s2 abcd to cd to dalni hogi na
13        if(j == s2.length()) return s1.length() - i; // delete remaining of s1 s1 abcd s2 ab to cd hatana hoga
14
15        if(dp[i][j] != -1) return dp[i][j];
16
17        if(s1.charAt(i) == s2.charAt(j)) {
18            return dp[i][j] = edit(s1, s2, i+1, j+1, dp);
19        }
20
21        int deleteFromS1 = 1 + edit(s1, s2, i + 1, j, dp);
22        int deleteFromS2 = 1 + edit(s1, s2, i, j + 1, dp);
23
24        return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
25    }
26
27}