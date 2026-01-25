// Last updated: 1/25/2026, 6:38:05 PM
1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3         int n = nums.length;
4
5        Arrays.sort(nums);
6
7        int minDiff = Integer.MAX_VALUE;
8
9        int i = 0;
10        int j = i+k-1;
11
12        while(j < n) {
13            int minElement = nums[i];
14            int maxElement = nums[j];
15
16            minDiff = Math.min(minDiff, maxElement - minElement);
17
18            i++;
19            j++;
20        }
21
22        return minDiff;
23    }
24}