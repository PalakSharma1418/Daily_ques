// Last updated: 1/7/2026, 4:29:34 PM
1class Solution {
2    public List<Integer> goodDaysToRobBank(int[] security, int time) {
3        int n = security.length;
4        List<Integer> result = new ArrayList<>();
5        if (n < 2 * time + 1) return result;
6
7        int[] nonInc = new int[n]; // Days before that are non-increasing
8        int[] nonDec = new int[n]; // Days after that are non-decreasing
9
10        // Fill non-increasing prefix counts--decreasing
11        // If security[i] is less than or equal to the previous day, increase the count.
12        for (int i = 1; i < n; i++) {
13            if (security[i] <= security[i - 1]) {
14                nonInc[i] = nonInc[i - 1] + 1;
15            }
16        }
17
18        // Fill non-decreasing suffix counts--increasing.
19        for (int i = n - 2; i >= 0; i--) {
20            if (security[i] <= security[i + 1]) {
21                nonDec[i] = nonDec[i + 1] + 1;
22            }
23        }
24        for (int i = time; i < n - time; i++) {
25            if (nonInc[i] >= time && nonDec[i] >= time) {
26                result.add(i);
27            }
28        }
29
30        return result;
31    }
32}
33