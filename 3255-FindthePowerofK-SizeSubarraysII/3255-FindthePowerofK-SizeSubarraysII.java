// Last updated: 1/17/2026, 2:20:19 PM
1class Solution {
2    public int[] resultsArray(int[] nums, int k) {
3        int n = nums.length;
4        int[] res = new int[n - k + 1];
5        if(k==1) return nums;
6
7        int len = 1; 
8        for (int i = 1; i < n; i++) {
9            if (nums[i] == nums[i - 1] + 1) {
10                len++;
11            } else {
12                len = 1;
13            }
14            if (i >= k - 1) {//i - k + 1 >= 0
15                if (len >= k) {
16                    res[i - k + 1] = nums[i];
17                } else {
18                    res[i - k + 1] = -1;
19                }
20            }
21        }
22
23        return res;
24    }
25}
26