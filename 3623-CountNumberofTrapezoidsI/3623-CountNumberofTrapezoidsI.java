// Last updated: 12/2/2025, 7:32:00 PM
1class Solution {
2    static final int M = (int)1e9 + 7;
3
4    public int countTrapezoids(int[][] points) {
5        // Map y -> count of points having that y-coordinate
6        Map<Integer, Integer> mp = new HashMap<>();
7        for (int[] point : points) {
8            int y = point[1];
9            mp.put(y, mp.getOrDefault(y, 0) + 1);
10        }
11
12        long result = 0;
13        long prevHorizontalLines = 0;
14
15        // Iterate over the hashmap
16        for (int count : mp.values()) {
17
18            long horizontalLines = (long) count * (count - 1) / 2;  // C(n, 2)
19
20            result = (result + horizontalLines * prevHorizontalLines) % M;
21
22            prevHorizontalLines += horizontalLines;
23        }
24
25        return (int)(result % M);
26    }
27}