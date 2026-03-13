// Last updated: 3/13/2026, 8:00:22 PM
1class Solution {
2    public long minNumberOfSeconds(int h, int[] t) {
3
4        PriorityQueue<long[]> pq = new PriorityQueue<>(
5            (a, b) -> Long.compare(a[0], b[0])
6        );
7
8        for(int i = 0; i < t.length; i++){
9            pq.add(new long[]{t[i], i, 1});
10        }
11
12        long res = 0;
13
14        while(h > 0){
15            long[] cur = pq.poll();
16
17            long tm = cur[0];
18            int id = (int)cur[1];
19            int x = (int)cur[2];
20
21            res = tm;
22            h--;
23
24            if(h > 0){
25                long nx = x + 1;
26                long nt = (long)t[id] * (nx * (nx + 1) / 2);
27                pq.add(new long[]{nt, id, nx});
28            }
29        }
30
31        return res;
32    }
33}