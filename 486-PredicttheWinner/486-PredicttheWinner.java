// Last updated: 8/1/2026, 9:07:53 AM
1class Solution {
2    public boolean predictTheWinner(int[] arr) {
3        int n = arr.length;
4        int[][] dp = new int[n][n];
5        int player1 = Optimal_game_strategy(arr, 0, n - 1, dp);
6        int total = 0;
7        for (int x : arr) total += x;
8        int player2 = total - player1;
9        return player1 >= player2;
10    }
11
12    private static int Optimal_game_strategy(int[] arr, int i, int j, int[][] dp) {
13        if (i > j) return 0;
14        if (dp[i][j] != 0) return dp[i][j];
15
16        int f = arr[i] + Math.min(
17            Optimal_game_strategy(arr, i + 2, j, dp),
18            Optimal_game_strategy(arr, i + 1, j - 1, dp)
19        );
20        int s = arr[j] + Math.min(
21            Optimal_game_strategy(arr, i + 1, j - 1, dp),
22            Optimal_game_strategy(arr, i, j - 2, dp)
23        );
24
25        return dp[i][j] = Math.max(f, s);
26    }
27}
28
29