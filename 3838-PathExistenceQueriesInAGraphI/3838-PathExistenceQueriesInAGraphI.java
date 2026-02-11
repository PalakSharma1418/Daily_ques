// Last updated: 2/11/2026, 7:20:58 AM
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            int d = nums[i] - nums[i - 1];
            if (d < 0) d = -d;
            prefix[i] = prefix[i - 1] + (d > maxDiff ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int start = Math.min(u, v);
            int end = Math.max(u, v);
            ans[i] = (prefix[end] - prefix[start] == 0);
        }

        return ans;
    }
}
