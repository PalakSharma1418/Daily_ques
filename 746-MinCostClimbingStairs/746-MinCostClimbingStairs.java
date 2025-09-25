// Last updated: 9/25/2025, 11:43:16 AM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        // Can start at step 0 or step 1
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }

    private int helper(int[] cost, int i, int[] dp) {
        if (i >= cost.length) return 0; // reached the top
        if (dp[i] != -1) return dp[i];

        int oneStep = helper(cost, i + 1, dp);
        int twoStep = helper(cost, i + 2, dp);

        return dp[i] = cost[i] + Math.min(oneStep, twoStep);
    }
}
