// Last updated: 7/3/2026, 9:44:15 AM
1class Solution {
2    public boolean carPooling(int[][] trips, int capacity) {
3       int[] arr = new int[1001];
4       for(int[]t : trips){
5        arr[t[1]]+=t[0];//bethe is point par
6        arr[t[2]]-=t[0];//utr gye is point par
7       }
8
9       for(int i=0 ; capacity>=0 && i<1001 ; i++){
10        capacity-=arr[i];
11       }
12        return capacity>=0;
13    }
14}