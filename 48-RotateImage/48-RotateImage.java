// Last updated: 8/6/2025, 4:50:55 PM
class Solution {
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        int n= matrix.length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<(matrix[0].length)/2;j++){
             int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - 1 - j];
            matrix[i][n - 1 - j] = temp;
            }
        }
    }
    public static void transpose(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr[0].length;j++){
                    int t=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=t;
                }
                
            }
}

}