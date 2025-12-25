// Last updated: 12/25/2025, 7:52:50 PM
1class Solution {
2    public long makeSubKSumEqual(int[] arr, int k) {
3        int n = arr.length;
4        boolean[] visited = new boolean[n];
5        long total = 0;
6        for (int i = 0; i < n; i++) {
7            if (visited[i]) continue;
8            List<Integer> sameValue = new ArrayList<>();
9            sameValue.add(arr[i]);
10            int next = (i + k) % n;        
11            while (next != i) { 
12                visited[next] = true;
13                sameValue.add(arr[next]);
14                next = (next + k) % n;
15            }
16
17            Collections.sort(sameValue);
18            int median = sameValue.get(sameValue.size() / 2);
19            
20            for (Integer integer : sameValue) {
21                total += Math.abs(integer - median);
22            }
23
24        }
25        return total;
26    }
27}