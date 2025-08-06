// Last updated: 8/6/2025, 4:46:08 PM
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count=0;
       long mod[]=new long[60];
       for(int i=0;i<time.length;i++){
        mod[time[i]%60]++;
       }
       count+=(mod[0]*(mod[0]-1))/2;
       count+=(mod[30]*(mod[30]-1))/2;
       for(int i=1;i<30;i++){
        count+=mod[i]*mod[60-i];
       }
       return count;
       
    }
}