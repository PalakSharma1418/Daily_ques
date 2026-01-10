// Last updated: 1/10/2026, 12:28:36 PM
1class Solution {
2    public int[] avoidFlood(int[] rains) {
3    int n = rains.length;
4
5    HashMap<Integer, List<Integer>> map = new HashMap<>();
6    for (int i = 0; i < n; i++) {
7        int lake = rains[i];
8        if (lake == 0) continue;      
9        if (!map.containsKey(lake)) {
10            map.put(lake, new ArrayList<>());
11        }
12        map.get(lake).add(i);  
13    }
14
15    int[] ans = new int[n];
16    Arrays.fill(ans, -1);
17
18    // min heap: [nextRainDay, lake]
19    PriorityQueue<int[]> pq =
20        new PriorityQueue<>((a, b) -> a[0] - b[0]);
21
22    HashSet<Integer> full = new HashSet<>();
23
24    for (int i = 0; i < n; i++) {
25            if (rains[i] > 0) {
26                int lake = rains[i];
27                map.get(lake).remove(0);
28                if (full.contains(lake)) {
29                    return new int[]{};
30                }
31                full.add(lake);
32                if (!map.get(lake).isEmpty()) {
33                    int nextRainDay = map.get(lake).get(0);
34                    pq.offer(new int[]{nextRainDay, lake});
35                }
36            }
37
38            else {
39                if (!pq.isEmpty()) {
40                    int[] cur = pq.poll();
41                    int lakeToDry = cur[1];
42                    ans[i] = lakeToDry;
43                    full.remove(lakeToDry);
44                } else {
45                    ans[i] = 1;
46                }
47            }
48        }
49
50
51    return ans;
52    }
53}