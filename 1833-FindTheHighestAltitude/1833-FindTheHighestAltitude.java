// Last updated: 8/6/2025, 4:44:59 PM
class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[]altitudes=new int[n+1];
        altitudes[0]=0; 
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gain[i];
        }
        altitudes[n]=sum; 
        for(int i=1;i<n;i++){
            altitudes[i]=altitudes[i-1]+gain[i-1];
        }
        int maxAlti=Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++){
            maxAlti=Math.max(maxAlti,altitudes[i]);
        }
        return maxAlti;  
    }
}