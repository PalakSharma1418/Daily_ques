// Last updated: 12/23/2025, 12:49:07 PM
1class Solution {
2    public int numWays(String s) {
3        int MOD = 1_000_000_007;
4        int n = s.length();
5
6        int totalOnes = 0;
7        for (char c : s.toCharArray()) {
8            if (c == '1') totalOnes++;
9        }
10
11        if (totalOnes % 3 != 0) return 0;
12
13        
14        if (totalOnes == 0) {
15            long ways = (long)(n - 1) * (n - 2) / 2;
16            return (int)(ways % MOD);
17        }
18
19        int k = totalOnes / 3;
20        int onesCount = 0;
21
22        long ways1 = 0; 
23        long ways2 = 0; 
24        for (int i = 0; i < n; i++) {
25            if (s.charAt(i) == '1') {
26                onesCount++;
27            }
28            if (onesCount == k) {
29                ways1++;
30            }
31            if (onesCount == 2 * k) {
32                ways2++;
33            }
34        }
35        return (int)((ways1 * ways2) % MOD);
36    }
37}
38