// Last updated: 1/12/2026, 7:24:42 PM
1class Solution {
2    public int eliminateMaximum(int[] dist, int[] speed) {
3        int n = dist.length;
4        
5        int[] vec = new int[n];
6        
7        for (int i = 0; i < n; i++) {
8            vec[i] = (int) Math.ceil((double) dist[i] / speed[i]);
9        }
10        
11        Arrays.sort(vec);
12        
13        int count = 1;
14        
15        int timePassed = 1;
16        for (int i = 1; i < n; i++) {
17            if (vec[i] - timePassed <= 0) {
18                return count;
19            }
20            
21            count++;
22            timePassed++;
23        }
24        
25        return count;
26    }
27}