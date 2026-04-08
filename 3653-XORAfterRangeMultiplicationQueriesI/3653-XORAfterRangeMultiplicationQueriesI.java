// Last updated: 4/8/2026, 3:30:45 PM
1class Solution {
2    final int mod = 1000000007;
3    public int xorAfterQueries(int[] nums, int[][] queries) {
4        for (int[] t : queries) {
5            int l = t[0];
6            int r = t[1];
7            int k = t[2];
8            int v = t[3];
9
10            int idx = l;
11            while (idx <= r) {
12                long temp = nums[idx];
13                nums[idx] = (int)((temp * v) % mod);
14                idx += k;
15            }
16        }
17        int ans = 0;
18        for (int num : nums) {
19            ans ^= num;
20        }
21        return ans;
22    }
23}