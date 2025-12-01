// Last updated: 12/1/2025, 7:12:13 AM
1class Solution {
2    public long maxRunTime(int n, int[] batteries) {
3       long l=0 ;
4       long r=0;
5       for(int no : batteries){
6            r+=no;
7       }
8       long ans=0;
9       while(l<=r){
10            long mid= l+(r-l)/2;
11            if(ispossible(batteries, n , mid)){
12                ans=mid;
13                l=mid+1;
14            }else{
15                r=mid-1;
16            }
17       }
18       return ans;
19    }
20    public static boolean ispossible( int[] batteries , int n , long mid){
21        long sum = 0;
22        for(int no : batteries){
23           long a = Math.min(no,mid);
24           sum+=a; 
25       }
26        return sum >= n * mid;
27
28    }
29}