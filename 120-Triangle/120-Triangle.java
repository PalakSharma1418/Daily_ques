// Last updated: 9/25/2025, 4:42:55 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return min(triangle, 0, 0, dp);
    }

    public int min(List<List<Integer>> triangle, int row, int col, int[][] dp) {
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int curr = triangle.get(row).get(col);
        int a = curr + min(triangle, row + 1, col, dp);
        int b = curr + min(triangle, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(a, b);
    }
}
