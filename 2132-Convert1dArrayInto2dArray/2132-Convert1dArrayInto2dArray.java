// Last updated: 10/26/2025, 6:47:44 PM
class Solution {
    public int[][] construct2DArray(int[] arr, int r, int c) {
        if(arr.length != r*c){
            return new int[0][0];
        }
        int ind=0;
        int mat[][] = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                mat[i][j]=arr[ind++];
            }
        }
        return mat;
    }
}