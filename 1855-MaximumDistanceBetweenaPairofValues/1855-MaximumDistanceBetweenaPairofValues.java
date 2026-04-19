// Last updated: 4/19/2026, 6:49:27 PM
1class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int max=0;
4        int n=nums1.length;
5        int m= nums2.length;
6        for(int i=0;i<n;i++){
7            int J_index=0;
8            int low=i;
9            int high=m-1;
10            while(low<=high){
11                int j= (low+high)/2;
12                if(nums1[i]<=nums2[j]){
13                    J_index=j;
14                    low=j+1;
15                }else{
16                    high=j-1;
17                }
18            }
19            max=Math.max(J_index-i,max);
20        }
21        return max;
22    }
23}