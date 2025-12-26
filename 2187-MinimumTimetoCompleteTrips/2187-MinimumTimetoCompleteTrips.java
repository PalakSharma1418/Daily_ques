// Last updated: 12/26/2025, 12:29:28 PM
1class Solution {
2    public long minimumTime(int[] time, int totalTrips) {
3        long ans=0;
4        int max = 0;
5        for(int n:time){
6            max=Math.max(n,max);
7        }
8        long low = 1, high = (long) max * totalTrips;
9        while(low<=high){
10            long mid=low+(high-low)/2;
11            if(ispossible(time,mid,totalTrips)){
12                ans=mid;
13                high=mid-1;
14            }else{
15                low=mid+1;
16            }
17        }
18        return ans;
19    }
20    public boolean ispossible(int[] time, long t, int trip) {
21    long sum = 0;
22    for (int i = 0; i < time.length; i++) {
23        sum += t / time[i];
24        if (sum >= trip) return true; 
25    }
26    return sum >= trip;
27}
28}