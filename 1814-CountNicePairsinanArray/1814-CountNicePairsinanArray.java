// Last updated: 12/25/2025, 6:58:42 PM
1class Solution {
2    public int countNicePairs(int[] nums) {
3        HashMap<Integer, Long> map = new HashMap<>();
4        int MOD = 1_000_000_007;
5
6        for (int i = 0; i < nums.length; i++) {
7            int key = nums[i] - rev(nums[i]);
8            map.put(key, map.getOrDefault(key, 0L) + 1);
9        }
10
11        long ans = 0;
12        for (long c : map.values()) {
13            ans = (ans + (c * (c - 1) / 2) % MOD) % MOD;
14        }
15
16        return (int) ans;
17    }
18
19    public int rev(int n) {
20        int ans = 0;
21        while (n > 0) {
22            ans = ans * 10 + (n % 10);
23            n /= 10;
24        }
25        return ans;
26    }
27}
28