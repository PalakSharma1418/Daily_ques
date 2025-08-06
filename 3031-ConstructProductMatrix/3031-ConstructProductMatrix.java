// Last updated: 8/6/2025, 4:42:11 PM
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        return productExceptSelf1(grid);
    }
    public static int[][] productExceptSelf1(int arr[][]){
        int n= arr.length;
        int m=arr[0].length;
        int [][] left =new int[n][m];
        int [][] right =new int[n][m];
        long last=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                left[i][j]=(int)last;
                last=(last*arr[i][j])%12345;
                // last=left[i][j];
            }
        }

        last=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                right[i][j]=(int)last;
                last=(last*(arr[i][j])%12345)%12345;
                
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            left[i][j]= ((left[i][j])%12345*(right[i][j])%12345)%12345;
        }
        return left;
    } 
}