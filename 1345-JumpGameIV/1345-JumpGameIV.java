// Last updated: 5/18/2026, 7:04:56 PM
1class Solution {
2    public int minJumps(int[] arr) {
3
4        int n = arr.length;
5
6        if (n == 1) {
7            return 0;
8        }
9        HashMap<Integer, List<Integer>> mp = new HashMap<>();
10
11        for (int i = 0; i < n; i++) {
12            mp.putIfAbsent(arr[i], new ArrayList<>());
13            mp.get(arr[i]).add(i);
14        }
15
16        Queue<Integer> q = new LinkedList<>();
17        boolean[] visited = new boolean[n];
18
19        q.offer(0);
20        visited[0] = true;
21
22        int steps = 0;
23
24        while (!q.isEmpty()) {
25
26            int size = q.size();
27
28            while (size-- > 0) {
29
30                int curr = q.poll();
31                if (curr == n - 1) {
32                    return steps;
33                }
34                int left = curr - 1;
35
36                if (left >= 0 && !visited[left]) {
37                    visited[left] = true;
38                    q.offer(left);
39                }
40
41                // move right
42                int right = curr + 1;
43
44                if (right < n && !visited[right]) {
45                    visited[right] = true;
46                    q.offer(right);
47                }
48
49                // same value jumps
50                if (mp.containsKey(arr[curr])) {
51
52                    for (int idx : mp.get(arr[curr])) {
53
54                        if (!visited[idx]) {
55                            visited[idx] = true;
56                            q.offer(idx);
57                        }
58                    }
59                    mp.remove(arr[curr]);
60                }
61            }
62
63            steps++;
64        }
65
66        return -1;
67    }
68}