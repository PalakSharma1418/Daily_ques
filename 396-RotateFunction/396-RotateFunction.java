// Last updated: 5/1/2026, 8:05:04 PM
1class Solution {
2    public int maxRotateFunction(int[] nums) {
3        int n = nums.length;
4
5        long sum = 0;
6        long F = 0;
7
8        for (int i = 0; i < n; i++) {
9            sum += nums[i];
10            F += (long) i * nums[i];
11        }
12
13        long ans = F;
14
15        for (int k = 1; k < n; k++) {
16            F = F + sum - (long) n * nums[n - k];
17            ans = Math.max(ans, F);
18        }
19
20        return (int) ans;
21    }
22}