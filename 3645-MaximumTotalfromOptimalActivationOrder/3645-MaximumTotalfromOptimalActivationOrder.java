// Last updated: 1/18/2026, 5:32:41 PM
1class Solution {
2    public long maxTotal(int[] value, int[] limit) {
3        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
4            if (a[0] == b[0]){
5                return b[1] - a[1]; 
6            } else {
7                return a[0] - b[0]; 
8            }
9        }); 
10        PriorityQueue<int[]> act = new PriorityQueue<>((a, b) -> a[0] - b[0]);   
11        for (int i = 0; i < limit.length; i++){
12            int[] toAdd = {limit[i], value[i]}; 
13            pq.offer(toAdd); 
14        }
15        long res = 0; 
16        int active = 0; 
17        while (!pq.isEmpty()){
18            if (active < pq.peek()[0]){
19                res += pq.peek()[1];
20                active++;
21                act.offer(pq.poll()); 
22                while (!pq.isEmpty() && active >= pq.peek()[0]){
23                    pq.poll(); 
24                }
25                while (!act.isEmpty() && active >= act.peek()[0]){
26                    active--; 
27                    act.poll(); 
28                }
29            }
30        }
31        return res; 
32    }
33}