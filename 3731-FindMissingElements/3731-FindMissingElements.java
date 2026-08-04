// Last updated: 8/4/2026, 6:55:36 PM
1class Solution {
2    public List<Integer> findMissingElements(int[] nums) {
3
4        boolean[] present = new boolean[101];
5
6        int mini = Integer.MAX_VALUE;
7        int maxi = Integer.MIN_VALUE;
8
9        for (int num : nums) {
10            present[num] = true;
11            mini = Math.min(mini, num);
12            maxi = Math.max(maxi, num);
13        }
14
15        List<Integer> ans = new ArrayList<>();
16
17        for (int i = mini; i <= maxi; i++) {
18            if (!present[i]) {
19                ans.add(i);
20            }
21        }
22
23        return ans;
24    }
25}