// Last updated: 9/7/2025, 3:04:57 PM
class Solution {
    public int change(int amount, int[] coins) {
        return coinBU(coins,amount);
    }
    public static int coinBU(int [] coin,int amount){
        int dp[][] = new int[coin.length+1][amount+1];
        for(int i=0;i<dp.length;i++){//row
            dp[i][0]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int amt =1; amt<dp[0].length;amt++){
                int inc=0,exc=0;
                if(amt>=coin[i-1]){
                    inc =dp[i][amt-coin[i-1]];
                }
                exc = dp[i-1][amt];
                dp[i][amt]= inc+exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        
    }
}
//tc recursionn 2 ki pow max(amt,coin)