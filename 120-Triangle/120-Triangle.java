// Last updated: 9/25/2025, 4:42:32 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); // mark unvisited
        }
        return min(triangle, 0, 0, 0, dp);
    }

    public int min(List<List<Integer>> triangle, int col, int row, int sum, int[][] dp) {
        if (row == triangle.size()) {
            return sum;
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return sum + dp[row][col];
        }

        int a = min(triangle, col, row + 1, sum + triangle.get(row).get(col), dp);
        int b = min(triangle, col + 1, row + 1, sum + triangle.get(row).get(col), dp);

        dp[row][col] = Math.min(a, b) - sum; // hume phele ki kya jarurat hum to yha se bottom tak ka store kar rhe hai isliye delte kiya

        return Math.min(a, b);
    }
}
