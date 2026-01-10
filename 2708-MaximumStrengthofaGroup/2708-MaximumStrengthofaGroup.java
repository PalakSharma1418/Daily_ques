// Last updated: 1/10/2026, 12:51:18 PM
1class Solution {
2    public long maxStrength(int[] nums) {
3        return helper(nums, 0, false, 1, 1);
4    }
5
6    public long helper(int[] nums, int i, boolean taken, long curMax, long curMin) {
7        if (i == nums.length) {
8            return taken ? curMax : Long.MIN_VALUE;
9        }
10        long pickMax = Math.max(nums[i], Math.max(nums[i] * curMax, nums[i] * curMin));
11        long pickMin = Math.min(nums[i], Math.min(nums[i] * curMax, nums[i] * curMin));
12        long take = helper(nums, i + 1, true, pickMax, pickMin);
13
14        long skip = helper(nums, i + 1, taken, curMax, curMin);
15
16        return Math.max(take, skip);
17    }
18}