// Last updated: 11/27/2025, 7:28:31 PM
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        long[] pre = new long[n + 1];
5        
6        for (int i = 0; i < n; i++) {
7            pre[i + 1] = pre[i] + nums[i];
8        }
9
10        long res = Long.MIN_VALUE;
11
12        for (int start = 0; start < k; start++) {
13            long currSum = 0;
14
15            for (int i = start; i + k - 1 < n; i += k) {
16                int r = i + k - 1; // full block
17                long blockSum = pre[r + 1] - pre[i];
18                currSum += blockSum;
19                res = Math.max(currSum, res);
20                if (currSum < 0)
21                    currSum = 0;
22            }
23        }
24
25        return res;
26
27    }
28}