// Last updated: 8/6/2025, 4:45:58 PM
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int arr[]= new int[n];
        for(int i=0;i<bookings.length;i++){
            int s=bookings[i][0]-1;
            int e=bookings[i][1];
            int val=bookings[i][2];
            arr[s]+=val;
            if(e<n){
                arr[e]-=val;
            }
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }
}