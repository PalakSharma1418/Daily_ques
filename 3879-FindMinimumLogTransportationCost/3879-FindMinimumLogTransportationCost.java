// Last updated: 8/6/2025, 4:40:49 PM
class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n<=k && m<=k) return 0;
        long mincost= Long.MAX_VALUE;
        if(m>k){
            for(long l=1;l<m;l++){
                long l2=m-l;
                if(l<=k && l2<=k && n<=k){
                    mincost= Math.min(mincost,l*l2);
                }
            }
        }
        if(n>k){
            for(long l=1;l<n;l++){
                long l2= n-l;
                if(l2<=k && l<=k && m<=k){
                    mincost= Math.min(l2*l,mincost);
                }
            }
        }
        return mincost;
    }
}