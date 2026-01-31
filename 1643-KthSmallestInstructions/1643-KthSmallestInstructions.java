// Last updated: 1/31/2026, 4:50:25 PM
1class Solution {
2    public long nCr(int n, int r) {
3            long[][] dp = new long[n + 1][r + 1];
4
5            for (int i = 0; i <= n; i++) {
6                for (int j = 0; j <= Math.min(i, r); j++) {
7
8                    // base cases
9                    if (j == 0 || j == i) {
10                        dp[i][j] = 1;
11                    } else {
12                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
13                    }
14                }
15            }
16            return dp[n][r];
17        }
18
19
20    public String kthSmallestPath(int[] destination, int k) {
21
22        int v = destination[0]; // vertical moves (V)
23        int h = destination[1]; // horizontal moves (H)
24
25        StringBuilder ans = new StringBuilder();
26
27        // jab tak moves bache hain
28        while (h > 0 || v > 0) {
29
30            // pehle try karte hain 'H'
31            if (h > 0) {
32                // agar yaha 'H' rakhein,
33                // to remaining positions = h+v-1
34                // remaining H = h-1
35                long count = nCr(h + v - 1, h - 1);
36
37                if (k <= count) {
38                    // k isi block me hai
39                    ans.append('H');
40                    h--;
41                } else {
42                    // H se start hone wali sab paths skip
43                    k -= count;
44                    ans.append('V');
45                    v--;
46                }
47            } else {
48                // agar H bache hi nahi
49                ans.append('V');
50                v--;
51            }
52        }
53
54        return ans.toString();
55    }
56}
57// https://chatgpt.com/c/697dc3e0-91c8-8322-ab1a-400c02f12ee1