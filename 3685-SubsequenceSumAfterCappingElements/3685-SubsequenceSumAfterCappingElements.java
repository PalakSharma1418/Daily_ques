// Last updated: 1/9/2026, 8:40:21 PM
1class Solution {
2    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
3        int n = nums.length;
4        boolean[] ans = new boolean[n];
5        Arrays.sort(nums);
6        boolean[] dp = new boolean[k + 1];
7        dp[0] = true;
8        int i = 0;
9
10        for (int x = 1; x <= n; x++) {
11            for (; i < n && nums[i] < x; i++) {
12                for (int j = k; j >= nums[i]; j--) {
13                    dp[j] = dp[j] || dp[j - nums[i]];
14                }
15            }
16            int ncapped = n - i;
17            for (int j = 0; j <= ncapped; j++) {
18                int times = j * x;
19                if (times > k) {
20                    break;
21                }
22                if (dp[k - times]) {
23                    ans[x - 1] = true;
24                    break;
25                }
26            }
27
28        }
29        return ans;
30    }
31}