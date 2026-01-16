// Last updated: 1/16/2026, 4:29:04 PM
1class Solution {
2    public int minElements(int[] nums, int limit, int goal) {
3        long sum = 0 ;
4        for(int n : nums){
5            sum+=n;
6        }
7        long required = Math.abs((long)goal - sum);
8
9        return (int)((required+limit-1)/limit);
10    }
11}