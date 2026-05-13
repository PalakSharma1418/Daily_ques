// Last updated: 5/13/2026, 7:01:22 PM
1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length;
4        int[] diff = new int[2 * limit + 2];
5
6        for (int i = 0; i < n / 2; i++) {
7            int a = nums[i];
8            int b = nums[n - 1 - i];
9
10            int lo = Math.min(a, b);
11            int hi = Math.max(a, b);
12
13            // Default: 2 moves for all sums
14            diff[2] += 2;
15            diff[2 * limit + 1] -= 2;
16
17            // 1 move range
18            diff[lo + 1] -= 1;
19            diff[hi + limit + 1] += 1;
20
21            // 0 move exact sum
22            diff[a + b] -= 1;
23            diff[a + b + 1] += 1;
24        }
25
26        int ans = Integer.MAX_VALUE;
27        int curr = 0;
28
29        for (int t = 2; t <= 2 * limit; t++) {
30            curr += diff[t];
31            ans = Math.min(ans, curr);
32        }
33
34        return ans;
35    }
36}