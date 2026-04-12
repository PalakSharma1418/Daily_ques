// Last updated: 4/12/2026, 8:01:10 AM
1class Solution {
2    public int[] findDegrees(int[][] matrix) {
3        int n = matrix.length;
4        int[]re = new int[n];
5        for(int i=0 ; i<n ; i++){
6            int d=0 ;
7            for(int j =0 ; j<n ; j++){
8                if(matrix[i][j] == 1){
9                    d++;
10                }
11            }
12            re[i]=d;
13        }
14        return re;
15    }
16}