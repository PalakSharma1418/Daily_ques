// Last updated: 8/6/2025, 4:50:30 PM
class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] m=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                m[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(m[i][j]==0){
                    for(int k=0;k<col;k++){
                        matrix[i][k]=0;
                    }
                    for(int k=0;k<row;k++){
                        matrix[k][j]=0;
                    }
                }
            }
        }
    }
}