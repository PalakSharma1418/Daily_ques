// Last updated: 8/6/2025, 4:42:35 PM
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n=grid.length;
       return(isvalid(grid,0,0,n,0));
        
    }
    public static boolean isvalid(int[][] arr,int r,int c,int n,int expect){
        if(r<0 ||c<0 || c>=n||r>=n || expect !=arr[r][c]){
            return false;
        }
        if(expect==n*n-1){
            return true;
        }
        boolean  ans1=isvalid(arr,r-2,c+1,n,expect+1);
        boolean  ans2=isvalid(arr,r-2,c-1,n,expect+1);
        boolean  ans3= isvalid(arr,r+2,c+1,n,expect+1);
        boolean  ans4=isvalid(arr,r+2,c-1,n,expect+1);
        boolean ans5=isvalid(arr,r-1,c+2,n,expect+1);
        boolean  ans6=isvalid(arr,r-1,c-2,n,expect+1);
        boolean  ans7=isvalid(arr,r+1,c+2,n,expect+1);
        boolean ans8=isvalid(arr,r+1,c-2,n,expect+1);
        return ans1||ans2||ans3||ans4||ans5||ans6||ans7||ans8;
    } 
}  