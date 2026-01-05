// Last updated: 1/5/2026, 3:30:02 PM
1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3        List<Integer> ans = new ArrayList<>();
4        int n = graph.length;
5        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
6        for(int i=0;i<n;i++){
7            map.put(i,new HashSet<>());
8        } 
9        int [] indegree = new int[n];
10        for(int i=0;i<n;i++){
11            indegree[i]= graph[i].length;
12            for(int j=0;j<graph[i].length;j++){
13                map.get(graph[i][j]).add(i);
14            }
15        }
16
17        Queue<Integer> q = new LinkedList<>();
18        for(int i =0 ;i<n;i++){
19            if(indegree[i]==0){
20                q.add(i);
21            }
22        }
23
24        while(!q.isEmpty()){
25            int r = q.poll();
26            ans.add(r);
27            for(int i: map.get(r)){
28                indegree[i]--;
29                if(indegree[i]==0){
30                    q.add(i);
31                }
32            }
33        }
34
35         Collections.sort(ans);
36         return ans;
37    }
38}