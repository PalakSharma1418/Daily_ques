// Last updated: 1/16/2026, 8:02:54 PM
1class Solution {
2    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
3        // 1. Add implicit boundary fences to new lists
4        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
5        h[hFences.length] = 1;
6        h[hFences.length + 1] = m;
7        
8        int[] v = Arrays.copyOf(vFences, vFences.length + 2);
9        v[vFences.length] = 1;
10        v[vFences.length + 1] = n;
11
12        Arrays.sort(h);
13        Arrays.sort(v);
14
15        Set<Integer> hGaps = new HashSet<>();
16        for (int i = 0; i < h.length; i++) {
17            for (int j = i + 1; j < h.length; j++) {
18                hGaps.add(h[j] - h[i]);
19            }
20        }
21
22        long maxSide = -1;
23        for (int i = 0; i < v.length; i++) {
24            for (int j = i + 1; j < v.length; j++) {
25                int currentGap = v[j] - v[i];
26                if (hGaps.contains(currentGap)) {
27                    maxSide = Math.max(maxSide, currentGap);
28                }
29            }
30        }
31
32        if (maxSide == -1) return -1;
33
34        long MOD = 1_000_000_007;
35        return (int) ((maxSide * maxSide) % MOD);
36    }
37}