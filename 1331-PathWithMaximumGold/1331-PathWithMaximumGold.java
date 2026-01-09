// Last updated: 1/9/2026, 10:57:30 AM
class Solution {
    int max;

    public int getMaximumGold(int[][] grid) {
        max = 0;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
        return max;
    }

    public void dfs(int[][] grid, int cr, int cc, int amt) {
        if (cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length || grid[cr][cc] == 0)
            return;

        int tem = grid[cr][cc];
        amt += tem;
        max = Math.max(max, amt); 

        grid[cr][cc] = 0;  

        dfs(grid, cr + 1, cc, amt);
        dfs(grid, cr - 1, cc, amt);
        dfs(grid, cr, cc + 1, amt);
        dfs(grid, cr, cc - 1, amt);

        grid[cr][cc] = tem;  // backtrack
    }
}
