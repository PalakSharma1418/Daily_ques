// Last updated: 2/1/2026, 8:40:27 AM
1class Solution {
2    public int minimumCost(int[] nums) {
3        int n = nums.length;
4        if(n==3){
5            return nums[0]+nums[1]+nums[2];
6        }
7        int ans = nums[0];
8        int min= Integer.MAX_VALUE;
9        int min2 = Integer.MAX_VALUE;
10        for(int i=1 ; i<n ;i++){
11            if(nums[i]<min){
12                min2=min;
13                min=nums[i];
14            }
15            else if(nums[i] < min2){
16                min2 = nums[i];
17            }
18        }
19        return ans+min+min2;
20    }
21}