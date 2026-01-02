// Last updated: 1/2/2026, 10:32:49 AM
1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int u : nums){
5            if(set.contains(u)){
6                return u;
7            }
8            set.add(u);
9        }
10        return -1;
11    }
12}