// Last updated: 8/6/2025, 4:40:46 PM
class Solution {
    public int maxBalancedShipments(int[] weight) {
        int c=0;
        int s=0;
        int n= weight.length;
        int mf= weight[0];
        for(int i=0;i<n;i++){
            mf= Math.max(weight[i], mf);
            if(weight[i]<mf){
                c++;
                if(i+1<n){
                    s=i+1;
                    mf= weight[i+1];
                    i=s;
                }
                else{
                    break;
                }
            }
        }
        return c;
    }
}