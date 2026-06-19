// Last updated: 6/19/2026, 10:55:14 AM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int n=gain.length;
4        int[]altitudes=new int[n+1];
5        altitudes[0]=0; 
6        int sum=0;
7        for(int i=0;i<n;i++){
8            sum+=gain[i];
9        }
10        altitudes[n]=sum; 
11        for(int i=1;i<n;i++){
12            altitudes[i]=altitudes[i-1]+gain[i-1];
13        }
14        int maxAlti=Integer.MIN_VALUE;
15        for(int i=0;i<n+1;i++){
16            maxAlti=Math.max(maxAlti,altitudes[i]);
17        }
18        return maxAlti;  
19    }
20}