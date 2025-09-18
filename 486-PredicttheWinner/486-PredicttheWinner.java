// Last updated: 9/18/2025, 1:01:20 PM
class Solution {
    public boolean predictTheWinner(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int player1 = Optimal_game_strategy(arr, 0, n - 1, dp);
        int total = 0;
        for (int x : arr) total += x;
        int player2 = total - player1;
        return player1 >= player2;
    }

    private static int Optimal_game_strategy(int[] arr, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int f = arr[i] + Math.min(
            Optimal_game_strategy(arr, i + 2, j, dp),
            Optimal_game_strategy(arr, i + 1, j - 1, dp)
        );
        int s = arr[j] + Math.min(
            Optimal_game_strategy(arr, i + 1, j - 1, dp),
            Optimal_game_strategy(arr, i, j - 2, dp)
        );

        return dp[i][j] = Math.max(f, s);
    }
}

