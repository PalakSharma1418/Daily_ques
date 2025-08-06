// Last updated: 8/6/2025, 4:46:07 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;// ship must at least carry the heaviest package
        int right=0;//max to max all will carry
        for(int i=0;i<weights.length;i++){
            left = Math.max(left,  weights[i]);
            right += weights[i];
        }
        int ans=-1;
        while(left<=right){
            int mid= (left+right)/2;
            if(possible(weights,days,mid)){
                ans=mid;
                right=mid-1;
              
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[] wt, int day, int mid){
        int d=1,t=0;
        int i=0;
        while(i<wt.length){
            if(t+wt[i]<=mid){
                t+=wt[i];
                i++;
            }
            else{
                d++;
                t=0;
            }
        }
        return d<=day;
    }
}