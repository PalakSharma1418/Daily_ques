// Last updated: 1/10/2026, 8:48:06 AM
1class Solution {
2    int[][] dp;
3
4    public int minimumDeleteSum(String s1, String s2) {
5        int n = s1.length();
6        int m = s2.length();
7        dp = new int[n][m];
8
9        for (int i = 0; i < n; i++)
10            for (int j = 0; j < m; j++)
11                dp[i][j] = -1;
12
13        return fun(s1, s2, 0, 0);
14    }
15
16    public int fun(String s1, String s2, int i, int j) {
17        if (i == s1.length()) {
18            int sum = 0;
19            for (int k = j; k < s2.length(); k++)
20                sum += s2.charAt(k);
21            return sum;
22        }
23        if (j == s2.length()) {
24            int sum = 0;
25            for (int k = i; k < s1.length(); k++)
26                sum += s1.charAt(k);
27            return sum;
28        }
29
30        if (dp[i][j] != -1)
31            return dp[i][j];
32
33        if (s1.charAt(i) == s2.charAt(j)) {
34            dp[i][j] = fun(s1, s2, i + 1, j + 1);
35        } else {
36            int deleteS1 = s1.charAt(i) + fun(s1, s2, i + 1, j);
37            int deleteS2 = s2.charAt(j) + fun(s1, s2, i, j + 1);
38            dp[i][j] = Math.min(deleteS1, deleteS2);
39        }
40
41        return dp[i][j];
42    }
43}
44