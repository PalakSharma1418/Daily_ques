// Last updated: 2/6/2026, 12:34:13 PM
1class Solution {
2    public int minRemoval(int[] nums, int k) {
3        Arrays.sort(nums);
4        int n = nums.length;
5
6        int i = 0;
7        int maxLen = 0;
8
9        for (int j = 0; j < n; j++) {
10            while ((long) nums[j] > (long) nums[i] * k) {
11                i++;
12            }
13            maxLen = Math.max(maxLen, j - i + 1);
14        }
15
16        return n - maxLen;
17    }
18}
19
20