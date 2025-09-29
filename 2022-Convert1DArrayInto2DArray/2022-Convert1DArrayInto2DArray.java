// Last updated: 9/29/2025, 11:19:48 AM
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