// Last updated: 1/11/2026, 8:09:06 AM
1class Solution {
2    public int centeredSubarrays(int[] nums) {
3        int len = nums.length;
4        int a=0;
5        for(int i=0;i<len;i++){
6            int sum=0;
7            Set<Integer> set = new HashSet<>();
8            for(int j=i;j<len;j++){
9                sum+=nums[j];
10                set.add(nums[j]);
11                if(set.contains(sum)){
12                    a++;
13                }
14            }
15        }
16        return a;
17    }
18}