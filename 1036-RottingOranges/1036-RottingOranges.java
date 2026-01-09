// Last updated: 1/9/2026, 10:58:07 AM
class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minutes++;

            for (int s = 0; s < size; s++) {
                int[] rm = q.poll();
                int r = rm[0];
                int c = rm[1];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; 
                        fresh--;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}
