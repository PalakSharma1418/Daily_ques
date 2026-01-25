// Last updated: 1/25/2026, 7:27:22 PM
1class Solution {
2    public long minimalKSum(int[] nums, int k) {
3        int n=nums.length;
4        Arrays.sort(nums);
5        int num=1;
6        int i=0;
7        long ans=0;
8        while(k>0){
9            if(i<n&&num==nums[i]){
10               
11                while(i+1<n&&nums[i]==nums[i+1]){
12                    i++;
13                }
14                 i++;
15                num++;
16            }else{
17                ans+=num;
18                num++;
19                k--;
20
21            }
22        }
23        return ans;
24    }
25}