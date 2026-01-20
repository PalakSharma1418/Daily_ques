// Last updated: 1/20/2026, 7:39:56 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] result = new int[n];
5
6        for (int i = 0; i < n; i++) {
7            int num = nums.get(i);
8            boolean found = false;
9
10            for (int x = 0; x < num; x++) {
11                if ( (x | (x + 1)) == num ) {
12                    result[i] = x;
13                    found = true;
14                    break;
15                }
16            }
17
18            if (!found) {
19                result[i] = -1;
20            }
21        }
22
23        return result;
24    }
25}