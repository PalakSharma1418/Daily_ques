// Last updated: 1/14/2026, 6:39:40 PM
1class Solution {
2
3    HashMap<String, Integer> memo = new HashMap<>();
4
5    public int maxOperations(int[] nums) {
6        return dfs(0, nums.length - 1, Integer.MIN_VALUE, nums);
7    }
8
9    private int dfs(int start, int end, int prev, int[] nums) {
10        if (start >= end) return 0;
11
12        String key = start + "," + end + "," + prev;
13        if (memo.containsKey(key)) {
14            return memo.get(key);
15        }
16
17        int ans = 0;
18
19        // front two
20        int sum1 = nums[start] + nums[start + 1];
21        if (prev == Integer.MIN_VALUE || sum1 == prev) {
22            ans = Math.max(ans, 1 + dfs(start + 2, end, sum1, nums));
23        }
24
25        // back two
26        int sum2 = nums[end] + nums[end - 1];
27        if (prev == Integer.MIN_VALUE || sum2 == prev) {
28            ans = Math.max(ans, 1 + dfs(start, end - 2, sum2, nums));
29        }
30
31        // front + back
32        int sum3 = nums[start] + nums[end];
33        if (prev == Integer.MIN_VALUE || sum3 == prev) {
34            ans = Math.max(ans, 1 + dfs(start + 1, end - 1, sum3, nums));
35        }
36
37        memo.put(key, ans);
38        return ans;
39    }
40}
41