// Last updated: 6/21/2026, 1:07:48 PM
1class Solution {
2    public int[][] matrixBlockSum(int[][] matrix, int k) {
3        int row = matrix.length;
4        int col = matrix[0].length;
5
6        for (int i = 0; i < row; i++) {
7            for (int j = 1; j < col; j++) {
8                matrix[i][j] += matrix[i][j - 1];
9            }
10        }
11        
12        int[][] ans = new int[row][col];
13        for(int i=0 ; i<row ; i++){
14            int br = Math.max(0,i-k);
15            int fr = Math.min(i+k,row-1);
16            for(int j=0 ; j<col ; j++){
17                int bc = Math.max(0, j - k);
18                int fc = Math.min(col - 1, j + k);
19                int sum = 0;
20
21                for (int r = br; r <= fr; r++) {
22                     sum += matrix[r][fc]  - (bc > 0 ? matrix[r][bc - 1] : 0);
23                }
24                ans[i][j] = sum;
25            }
26        }
27        return ans;
28    }
29}