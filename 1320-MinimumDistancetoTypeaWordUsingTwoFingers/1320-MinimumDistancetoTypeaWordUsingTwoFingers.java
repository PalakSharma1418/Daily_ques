// Last updated: 4/12/2026, 8:12:54 PM
1class Solution {
2    public int minimumDistance(String word) {
3        int n = word.length();
4        if (n <= 2) return 0;
5        int[] dp = new int[27];
6        for (int i = 0; i < 27; i++) dp[i] = Integer.MAX_VALUE;
7        
8        char[] w = word.toCharArray();
9        dp[26] = dist(w[1], w[0]);
10        dp[w[0] - 'A'] = 0;
11        for (int i = 2; i < n; i++) {
12            int delta = dist(w[i], w[i - 1]); 
13            int best = dp[26];     
14            for (int j = 0; j < 27; j++) {
15                if (dp[j] < best) {
16                   int cost = (j == 26 ? 0 : dist(w[i], (char)(j + 'A')));
17                    best = Math.min(best, dp[j] + cost);
18                }
19                if (dp[j] < Integer.MAX_VALUE) dp[j] += delta;
20            }
21            dp[w[i - 1] - 'A'] = Math.min(dp[w[i - 1] - 'A'], best);
22        }
23        int res = Integer.MAX_VALUE;
24        for (int v : dp) res = Math.min(res, v);
25        return res;
26    }
27    private int dist(char a, char b) {
28        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
29        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
30        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
31    }
32}