// Last updated: 1/3/2026, 12:04:02 PM
1class Solution {
2    public int orangesRotting(int[][] grid) {
3
4        int n = grid.length;
5        int m = grid[0].length;
6
7        Queue<int[]> q = new LinkedList<>();
8        int fresh = 0;
9        for (int i = 0; i < n; i++) {
10            for (int j = 0; j < m; j++) {
11                if (grid[i][j] == 2) {
12                    q.add(new int[]{i, j});
13                }
14                if (grid[i][j] == 1) {
15                    fresh++;
16                }
17            }
18        }
19
20        int[] dr = {-1, 1, 0, 0};
21        int[] dc = {0, 0, -1, 1};
22
23        int minutes = 0;
24        while (!q.isEmpty() && fresh > 0) {
25            int size = q.size();
26            minutes++;
27
28            for (int s = 0; s < size; s++) {
29                int[] rm = q.poll();
30                int r = rm[0];
31                int c = rm[1];
32
33                for (int i = 0; i < 4; i++) {
34                    int nr = r + dr[i];
35                    int nc = c + dc[i];
36
37                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
38                        grid[nr][nc] = 2; 
39                        fresh--;
40                        q.add(new int[]{nr, nc});
41                    }
42                }
43            }
44        }
45
46        return fresh == 0 ? minutes : -1;
47    }
48}
49