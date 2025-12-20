// Last updated: 12/20/2025, 11:16:14 AM
1class Solution {
2    public boolean isPossible(int[] nums) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        Map<Integer, Integer> end = new HashMap<>();
5
6        for (int n : nums) {
7            freq.put(n, freq.getOrDefault(n, 0) + 1);
8        }
9
10        for (int n : nums) {
11            if (freq.get(n) == 0) continue;
12
13            // extend previous subsequence
14            if (end.getOrDefault(n - 1, 0) > 0) {
15                end.put(n - 1, end.get(n - 1) - 1);
16                end.put(n, end.getOrDefault(n, 0) + 1);
17            }
18            // start new subsequence
19            else if (freq.getOrDefault(n + 1, 0) > 0 &&
20                     freq.getOrDefault(n + 2, 0) > 0) {
21                freq.put(n + 1, freq.get(n + 1) - 1);
22                freq.put(n + 2, freq.get(n + 2) - 1);
23                end.put(n + 2, end.getOrDefault(n + 2, 0) + 1);
24            }
25            //  not possible
26            else {
27                return false;
28            }
29
30            freq.put(n, freq.get(n) - 1);
31        }
32
33        return true;
34    }
35}
36