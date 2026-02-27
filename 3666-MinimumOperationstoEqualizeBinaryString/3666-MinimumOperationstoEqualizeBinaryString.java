// Last updated: 2/27/2026, 6:56:56 PM
1class Solution {
2    public int minOperations(String s, int k) {
3        int n = s.length();
4
5        TreeSet<Integer>[] ts = new TreeSet[2];
6        Arrays.setAll(ts, i -> new TreeSet<>());
7
8        for (int i = 0; i <= n; i++) {
9            ts[i % 2].add(i);
10        }
11
12        int cnt0 = 0;
13        for (char c : s.toCharArray()) {
14            if (c == '0') {
15                cnt0++;
16            }
17        }
18
19        ts[cnt0 % 2].remove(cnt0);
20
21        Deque<Integer> q = new ArrayDeque<>();
22        q.offer(cnt0);
23
24        int ans = 0;
25        while (!q.isEmpty()) {
26            for (int size = q.size(); size > 0; --size) {
27                int cur = q.poll();
28                if (cur == 0) {
29                    return ans;
30                }
31
32                int l = cur + k - 2 * Math.min(cur, k);
33                int r = cur + k - 2 * Math.max(k - n + cur, 0);
34
35                TreeSet<Integer> t = ts[l % 2];
36
37                Integer next = t.ceiling(l);
38                while (next != null && next <= r) {
39                    q.offer(next);
40                    t.remove(next);
41                    next = t.ceiling(l);
42                }
43            }
44            ans++;
45        }
46
47        return -1;
48    }
49}