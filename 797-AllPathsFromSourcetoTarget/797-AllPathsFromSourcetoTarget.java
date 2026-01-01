// Last updated: 1/1/2026, 12:40:32 PM
1class Solution {
2    List<List<Integer>> result = new ArrayList<>();
3    List<Integer> path = new ArrayList<>(); 
4
5    public void dfs(int n, int target, int[][] graph){
6        if(n == target){
7            result.add(new ArrayList<>(path));
8            return;
9        }
10
11        for(int next: graph[n]){
12            path.add(next);
13            dfs(next, target, graph);
14            path.remove(path.size() - 1); 
15        }
16    }
17    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
18        int target = graph.length - 1;
19        path.add(0); 
20        dfs(0, target, graph);
21        return result;
22    }
23}