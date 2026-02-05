// Last updated: 2/5/2026, 12:51:41 PM
1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int[] result = new int[n];
5
6        for (int i = 0; i < n; i++) {
7            if (nums[i] == 0) {
8                result[i] = 0;
9            } else {
10                int steps = nums[i];
11                int newIndex = ((i + steps) % n + n) % n;
12                result[i] = nums[newIndex];
13            }
14        }
15        return result;
16    }
17}