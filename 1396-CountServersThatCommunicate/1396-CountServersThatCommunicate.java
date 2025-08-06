// Last updated: 8/6/2025, 4:45:43 PM
class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }

        int ans = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1))
                    ans++;

        return ans;

    }
}