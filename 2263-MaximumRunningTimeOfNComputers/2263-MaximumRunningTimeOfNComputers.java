// Last updated: 12/11/2025, 7:35:20 AM
class Solution {
    public long maxRunTime(int n, int[] batteries) {
       long l=0 ;
       long r=0;
       for(int no : batteries){
            r+=no;
       }
       long ans=0;
       while(l<=r){
            long mid= l+(r-l)/2;
            if(ispossible(batteries, n , mid)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
       }
       return ans;
    }
    public static boolean ispossible( int[] batteries , int n , long mid){
        long sum = 0;
        for(int no : batteries){
           long a = Math.min(no,mid);
           sum+=a; 
       }
        return sum >= n * mid;

    }
}