// Last updated: 8/30/2025, 8:13:51 PM
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n= prices.length;
        long orp=0;
        for(int i=0;i<n;i++){
            orp+=(long) prices[i]*strategy[i];
        }
        long pc[] = new long[n+1];
        long [] pp = new long[n+1];

        for(int j=0;j<n;j++){
            pp[j+1]=pp[j]+prices[j];
            pc[j+1]=pc[j]+(long) prices[j]*strategy[j];
            
        }

        long maxgain=0;
        int h=k/2;
        for(int i=0;i+k<=n;i++){
            int j=k+i;
            long o1=pc[j]-pc[i];
            long o2 = pp[j]-pp[h+i];
            long  g=o2-o1;
            maxgain=Math.max(maxgain,g);
        }
        return orp+maxgain;
    }
}