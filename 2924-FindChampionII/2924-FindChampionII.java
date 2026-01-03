// Last updated: 1/3/2026, 11:26:41 AM
1class Solution {
2    public int findChampion(int n, int[][] edges) {
3        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
4        for(int i=0;i<n;i++){
5            map.put(i, new HashMap<>());
6        }
7        for(int i=0;i<edges.length;i++){
8            int s = edges[i][0];
9            int d = edges[i][1];
10            map.get(s).put(d,0);
11        }
12
13        int[]indegree = new int[n];
14        for(int i=0;i<n;i++){
15            for(int key :  map.get(i).keySet()){
16                indegree[key]++;
17            }
18        }
19        int c=0;
20        int first=-1;
21        for(int i =0;i<n;i++){
22            if(indegree[i]==0){
23                c++;
24                if(first==-1) first=i;
25            } 
26        }
27
28        return c==1?first:-1;
29    }
30}