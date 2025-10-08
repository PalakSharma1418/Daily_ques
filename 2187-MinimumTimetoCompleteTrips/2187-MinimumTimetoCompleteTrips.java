// Last updated: 10/8/2025, 4:45:24 PM
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long ans=0;
        int max = 0;
        for(int n:time){
            max=Math.max(n,max);
        }
        long low = 1, high = (long) max * totalTrips;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(ispossible(time,mid,totalTrips)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[] time, long t, int trip) {
    long sum = 0;
    for (int i = 0; i < time.length; i++) {
        sum += t / time[i];
        if (sum >= trip) return true; 
    }
    return sum >= trip;
}
}