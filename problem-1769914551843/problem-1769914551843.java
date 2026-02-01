// Last updated: 2/1/2026, 8:25:51 AM
1class Solution {
2    public int finalElement(int[] arr) {
3        int n = arr.length;
4        if(n==1) return arr[0];
5        if(n==2){
6            return Math.max(arr[0],arr[1]);
7        }
8
9        int ans= Math.max(arr[0],arr[n-1]);
10        return ans;
11        
12    }
13}