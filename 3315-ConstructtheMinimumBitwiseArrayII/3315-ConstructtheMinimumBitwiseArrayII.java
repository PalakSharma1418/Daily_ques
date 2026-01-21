// Last updated: 1/21/2026, 7:40:26 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] result = new int[n];
5        for (int i = 0; i < n; i++) {
6            int num = nums.get(i);
7            if (num == 2) {
8                result[i] = -1;
9                continue;
10            }
11            boolean found = false;
12            for (int j = 1; j < 32; j++) {
13                // if jth bit is set, skip
14                if ((num & (1 << j)) != 0) {
15                    continue;
16                }
17                // found an unset bit at position j
18                // flip (j-1)th bit
19                result[i] = num ^ (1 << (j - 1));
20                found = true;
21                break;
22            }
23            if (!found) {
24                result[i] = -1;
25            }
26        }
27
28        return result;
29    }
30}