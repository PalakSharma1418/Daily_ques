// Last updated: 8/6/2025, 4:50:39 PM
class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][]= new int[n][n];
        int minc=0,minr=0,maxc=arr[0].length-1,maxr=arr.length-1;
        int te= n*n;
        int c=0;
        int s=1;
        while(c<te){
                for(int i=minc;i<=maxc && c<te;i++){
                    // System.out.print(arr[minr][i]+" ");
                    
                    arr[minr][i]=s++;
                    c++;
                }
                minr++;
                for(int i=minr;i<=maxr && c<te;i++){
                    // System.out.print(arr[i][maxc]+" ");
                    arr[i][maxc]=s++;
                    c++;
                }
                maxc--;
                for(int i= maxc;i>=minc && c<te;i--){
                    // System.out.print(arr[maxr][i]+" ");
                    arr[maxr][i]=s++;
                    c++;
                }
                maxr--;
                for(int i=maxr;i>=minr && c<te;i--){
                    // System.out.print(arr[i][minc]+" ");
                    arr[i][minc]=s++;
                    c++;
                }
                minc++;
            }
            return arr;
    }
    
}