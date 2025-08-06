// Last updated: 8/6/2025, 4:46:42 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long lo=0;
        long hi=0;
        for(int i=0;i<piles.length;i++){
            hi+=piles[i];
        }
        long ans=0;  
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isitpossible(mid,piles,h)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return (int)(ans);
        
    }public static boolean isitpossible(long mid,int a[],long h){
        int hour=0;
        for(int i=0;i<a.length;i++){
            hour+=(Math.ceil((double)a[i]/(mid)));
        }
        return hour<=h;
        }
}