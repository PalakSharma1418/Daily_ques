// Last updated: 12/28/2025, 11:45:37 AM
1class Solution {
2    public int minimumSubarrayLength(int[] nums, int k) {
3        int length=nums.length;
4        int len=length+1,val=0;
5        for(int i=0;i<length;i++)
6        {
7            val=0;
8            for(int j=i;j<length;j++)
9            {
10                val|=nums[j];
11                if(val>=k)
12                {
13                    len=Math.min(len,j+1-i);
14                }
15            }
16        }
17        return len == length+1 ? -1 : len;
18    }
19}