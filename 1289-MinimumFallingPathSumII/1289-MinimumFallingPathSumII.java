// Last updated: 9/12/2025, 1:22:35 PM
class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n = matrix.length;
        int m = matrix[0].length;

        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE); // yha -100 ke alwa usse badi value daal skte h 100 se ke alwa kyuki maan lo 100 cell hue to 10^4 ayega 

        for(int col=0;col<matrix[0].length;col++){
            ans=Math.min(ans,Minimum(matrix,0,col,dp));
        }
        return ans;
    }
    public static int Minimum(int[][] matrix , int cr,int cc,int[][]dp){

        // if(cc<0 || cc >= matrix[0].length){
        //     return Integer.MAX_VALUE;
        // }
        if(cr == matrix.length-1){
            return  matrix[cr][cc];
        }

         if (dp[cr][cc] != Integer.MAX_VALUE) return dp[cr][cc];
        
        // int ld = Minimum(matrix,cr+1,cc-1,dp);//left diagonal
        // int rd = Minimum(matrix,cr+1,cc+1,dp);//right diagonal
        // int d = Minimum(matrix,cr+1,cc,dp);//direct 
        // return dp[cr][cc] = Math.min(rd,Math.min(ld,d))+matrix[cr][cc];

        int ans = Integer.MAX_VALUE;
		for (int col = 0; col < matrix[0].length; col++) {
			if (col == cc) {
				continue;
			}
			ans = Math.min(ans, Minimum(matrix, cr + 1, col, dp));
		}
		return dp[cr][cc] = ans += matrix[cr][cc];
    } 

}