// Last updated: 4/23/2026, 8:19:16 AM
1class Solution {
2    public long[] distance(int[] nums) {
3        Map<Integer, List<Integer>> map = new HashMap<>();
4
5        for (int i = 0; i < nums.length; i++) {
6            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
7        }
8
9        long[] ans = new long[nums.length];
10
11        for (List<Integer> idx : map.values()) {
12            int k = idx.size();
13
14            long[] prefix = new long[k];
15            prefix[0] = idx.get(0);
16
17            for (int i = 1; i < k; i++) {
18                prefix[i] = prefix[i - 1] + idx.get(i);
19            }
20
21            for (int i = 0; i < k; i++) {
22                long left = (i > 0) ? (long)i * idx.get(i) - prefix[i - 1] : 0;
23                long right = (i < k - 1) ?
24                        (prefix[k - 1] - prefix[i]) - (long)(k - i - 1) * idx.get(i) : 0;
25
26                ans[idx.get(i)] = left + right;
27            }
28        }
29
30        return ans;
31    }
32}