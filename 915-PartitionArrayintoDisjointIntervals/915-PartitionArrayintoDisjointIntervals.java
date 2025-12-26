// Last updated: 12/26/2025, 11:15:17 AM
1class Solution {
2    public int partitionDisjoint(int[] nums) {
3      int n = nums.length; 
4      int left_max[] =  new int[n];
5      int right_min[]= new int[n];
6      left_max[0]=nums[0];
7      for(int i=1; i< n ;i++){
8            left_max[i]=Math.max(left_max[i-1],nums[i-1]);
9      }
10      right_min[n-1]=nums[n-1];
11      for(int i=n-2; i>=0 ;i--){
12         right_min[i]=Math.min(right_min[i+1],nums[i+1]);
13      }
14
15      for(int i=0; i< n ;i++){
16         System.out.println(left_max[i]+" i "+right_min[i]);
17      }
18      
19        int ans=0;
20        for(int i=0; i<n;i++){
21            if(left_max[i]<= right_min[i]){
22                ans=i;
23                break;
24            }
25        }
26      return ans+1;
27    }
28}