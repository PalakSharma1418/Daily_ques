// Last updated: 3/8/2026, 8:11:00 AM
1class Solution {
2    public int smallestBalancedIndex(int[] nums) {
3        int n = nums.length ;
4        long[] right  = new long[n];
5        right[n-1] = nums[n-1];
6        for(int i= n-2 ; i>=0 ; i--){
7            // right[i]= right[i+1]*nums[i];
8            if(right[i+1] > Long.MAX_VALUE/nums[i]){
9                right[i]=Long.MAX_VALUE;
10            }
11            else{
12                right[i] = right[i+1]*nums[i];
13            }
14        }
15        long leftSum = 0;
16        for(int i=0 ; i<n ; i++){
17            long rightProduct ;
18            if(i==n-1){
19                rightProduct = 1;
20            }
21            else{
22                rightProduct = right[i+1];
23            }
24            if(leftSum==rightProduct) return i;
25            leftSum+=nums[i];
26        }
27        return -1;
28    }
29}