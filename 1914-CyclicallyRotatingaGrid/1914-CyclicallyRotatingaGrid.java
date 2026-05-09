// Last updated: 5/9/2026, 7:25:26 PM
1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int T = 0, L = 0;
4        int B = grid.length - 1, R = grid[0].length - 1;
5
6        while (T < B && L < R) {
7            int len = B - T, wid = R - L;
8            int perimeter = 2 * len + 2 * wid;
9            int r = k % perimeter;
10
11            while (r-- > 0) {
12                int tmp = grid[T][L];
13
14                for (int i = L; i < R; i++)
15                    grid[T][i] = grid[T][i + 1];
16
17                for (int i = T; i < B; i++)
18                    grid[i][R] = grid[i + 1][R];
19
20                for (int i = R; i > L; i--)
21                    grid[B][i] = grid[B][i - 1];
22
23                for (int i = B; i > T; i--)
24                    grid[i][L] = grid[i - 1][L];
25
26                grid[T + 1][L] = tmp;
27            }
28
29            T++; L++;
30            B--; R--;
31        }
32
33        return grid;
34    }
35}