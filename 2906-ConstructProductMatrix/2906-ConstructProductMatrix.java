// Last updated: 3/24/2026, 7:42:43 PM
1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        return productExceptSelf1(grid);
4    }
5    public static int[][] productExceptSelf1(int arr[][]){
6        int n= arr.length;
7        int m=arr[0].length;
8        int [][] left =new int[n][m];
9        int [][] right =new int[n][m];
10        long last=1;
11        for(int i=0;i<n;i++){
12            for(int j=0;j<m;j++){
13                left[i][j]=(int)last;
14                last=(last*arr[i][j])%12345;
15                // last=left[i][j];
16            }
17        }
18
19        last=1;
20        for(int i=n-1;i>=0;i--){
21            for(int j=m-1;j>=0;j--){
22                right[i][j]=(int)last;
23                last=(last*(arr[i][j])%12345)%12345;
24                
25            }
26        }
27        
28        for(int i=0;i<n;i++){
29            for(int j=0;j<m;j++)
30            left[i][j]= ((left[i][j])%12345*(right[i][j])%12345)%12345;
31        }
32        return left;
33    } 
34}