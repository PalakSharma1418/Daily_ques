// Last updated: 2/1/2026, 2:21:24 PM
1class Solution {
2    public int[] findOriginalArray(int[] changed) {
3        int n = changed.length;
4        if (n % 2 != 0) return new int[0];
5
6        Arrays.sort(changed);
7        Map<Integer, Integer> freq = new HashMap<>();
8
9        for (int x : changed) {
10            freq.put(x, freq.getOrDefault(x, 0) + 1);
11        }
12
13        int[] original = new int[n / 2];
14        int idx = 0;
15
16        for (int x : changed) {
17            if (freq.get(x) == 0) continue;
18
19            if (x == 0) {
20                if (freq.get(x) < 2) return new int[0];
21                original[idx++] = 0;
22                freq.put(0, freq.get(0) - 2);
23            } else {
24                if (freq.getOrDefault(2 * x, 0) == 0)
25                    return new int[0];
26
27                original[idx++] = x;
28                freq.put(x, freq.get(x) - 1);
29                freq.put(2 * x, freq.get(2 * x) - 1);
30            }
31        }
32
33        return original;
34    }
35}
36