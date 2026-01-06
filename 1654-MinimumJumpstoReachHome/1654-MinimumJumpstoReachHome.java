// Last updated: 1/6/2026, 11:45:41 AM
1class Solution {
2    class Pair {
3        int pos;
4        boolean dir;
5        public Pair(int pos, boolean dir) {
6            this.pos = pos;
7            this.dir = dir;
8        }
9    }
10    public int minimumJumps(int[] forbidden, int a, int b, int x) {
11        int limit = 2000 + 2 * b + 1;
12        boolean[] visited = new boolean[limit];
13        for (int num: forbidden) {
14            visited[num] = true;
15        }
16        int step = 0;
17        Queue<Pair> q = new LinkedList<>();
18        q.add(new Pair(0, false));
19        visited[0] = true;
20        while (!q.isEmpty()) {
21            int size = q.size();
22            for (int i = 0; i < size; i++) {
23                Pair p = q.poll();
24                int pos = p.pos;
25                boolean dir = p.dir;
26              
27                if (pos == x) return step;
28                
29                if (dir==false) {
30                    int backward = pos - b;
31                  
32                    if (backward > 0 && !visited[backward]) {
33                        q.offer(new Pair(backward, true));
34                        visited[backward] = true;
35                    }
36                }
37                
38                int forward = pos + a;
39           
40                if (forward < limit && !visited[forward]) {
41                    q.offer(new Pair(forward, false));
42                    visited[forward] = true;
43                }
44              
45                
46            }
47            step++;
48        }
49        return -1;
50    }
51}