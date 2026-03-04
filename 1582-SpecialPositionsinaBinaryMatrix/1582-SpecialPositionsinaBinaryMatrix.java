// Last updated: 3/4/2026, 7:05:54 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;          // → number of rows
4        int n = mat[0].length;       // → number of columns
5        int count = 0;                // → we'll count special positions here
6
7        // Walk through every cell in the matrix
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                // Is this cell a candidate? Only if it's a 1
11                if (mat[i][j] == 1) {
12                    boolean special = true;   // start by assuming it's special
13
14                    // --- CHECK THE ROW (left to right, skipping the cell itself) ---
15                    for (int col = 0; col < n; col++) {
16                        if (col != j && mat[i][col] == 1) {
17                            special = false;   // found another 1 in the same row → not special
18                            break;
19                        }
20                    }
21
22                    // --- IF THE ROW IS CLEAN, CHECK THE COLUMN ---
23                    if (special) {
24                        for (int row = 0; row < m; row++) {
25                            if (row != i && mat[row][j] == 1) {
26                                special = false;   // found another 1 in the same column → not special
27                                break;
28                            }
29                        }
30                    }
31
32                    // --- IF BOTH ROW AND COLUMN ARE CLEAN, WE HAVE A WINNER ---
33                    if (special) {
34                        count++;
35                    }
36                }
37            }
38        }
39        return count;
40    }
41}