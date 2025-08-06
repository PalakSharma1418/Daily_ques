// Last updated: 8/6/2025, 4:45:35 PM

class Solution {
    public int minStartValue(int[] nums) {
        
        int n=nums.length;
        int l=1,h=Integer.MAX_VALUE;
        int ans=0;
        while(l<=h){
            int start=l+(h-l)/2;
            if(poss(start,nums)){
                ans=start;
                h=start-1;
            }else{
                l=start+1;

            }
        }
        return ans;
    }
    public boolean poss(int start,int[] ar){
        int s=start;
        for(int i=0;i<ar.length;i++){
                if(s+ar[i]<=0){
                    return false;
                }
                s=s+ar[i];
            }
        return true;
    }
}