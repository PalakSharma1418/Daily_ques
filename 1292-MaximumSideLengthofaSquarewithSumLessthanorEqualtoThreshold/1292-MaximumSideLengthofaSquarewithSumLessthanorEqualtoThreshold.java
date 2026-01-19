// Last updated: 1/19/2026, 8:29:59 PM
1class Solution {
2    public int maxSideLength(int[][] mat, int threshold) {
3        int rows = mat.length;
4        int cols = mat[0].length;
5
6        int[][] prefix = new int[rows][cols];
7
8        // Build prefix sum
9        for (int i = 0; i < rows; i++) {
10            for (int j = 0; j < cols; j++) {
11                prefix[i][j] = mat[i][j]
12                        + (i > 0 ? prefix[i - 1][j] : 0)
13                        + (j > 0 ? prefix[i][j - 1] : 0)
14                        - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0);
15            }
16        }
17
18        int best = 0;
19
20        for (int i = 0; i < rows; i++) {
21            for (int j = 0; j < cols; j++) {
22                for (int k = best; k < Math.min(rows - i, cols - j); k++) {
23                    //bottom right cell (r2, c2)
24                    int r2 = i + k;
25                    int c2 = j + k;
26
27                    int sum = prefix[r2][c2];
28                    if (i > 0) sum -= prefix[i - 1][c2];
29                    if (j > 0) sum -= prefix[r2][j - 1];
30                    if (i > 0 && j > 0) sum += prefix[i - 1][j - 1];
31
32                    if (sum <= threshold) {
33                        best = k + 1;
34                    } else {
35                        break;
36                    }
37                }
38            }
39        }
40
41        return best;
42    }
43}