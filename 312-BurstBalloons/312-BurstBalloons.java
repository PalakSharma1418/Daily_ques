// Last updated: 9/18/2025, 12:26:17 PM
class Solution {
    public int maxCoins(int[] arr) {
        int [] a = new int[arr.length+2];//ek agge phele or last mai 1 add kardiya
        a[0]=a[a.length-1]=1;
        for(int i=0;i<arr.length;i++){
            a[i+1]=arr[i];
        }
        int[][] dp = new int[a.length][a.length];
        return Burst_Coin(a,0,a.length-1,dp);
	}
    public static int Burst_Coin(int[]a,int i,int j,int[][]dp) {
        if(i+1==j) {
            return 0;
        }
        if(dp[i][j]!=0)
            return dp[i][j];
        int ans=Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++) {
            int fs=Burst_Coin(a,i,k,dp);//i*k
            int ss=Burst_Coin(a,k,j,dp);//k*j;
            int self=a[i]*a[k]*a[j];
            ans=Math.max(ans, fs+ss+self);
        }
        return dp[i][j]=ans;
    }

}