// Last updated: 1/9/2026, 10:52:22 AM
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int lo = 0, hi = queries.length, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canZero(nums, queries, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            if (target == 0) continue;

            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int j = 0; j < k; j++) {
                int l = queries[j][0];
                int r = queries[j][1];
                int val = queries[j][2];

                if (l <= i && i <= r) {
                    for (int s = target; s >= val; s--) {
                        dp[s] |= dp[s - val];
                    }
                }
            }

            if (!dp[target]) return false;
        }
        return true;
    }
}
