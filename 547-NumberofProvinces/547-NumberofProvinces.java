// Last updated: 12/30/2025, 7:15:14 PM
1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        Set<Integer> visited = new HashSet<>();
4        int provinces = 0;
5
6        for (int i = 0; i < isConnected.length; i++) {
7            if (!visited.contains(i)) {
8                dfs(i, isConnected, visited);
9                provinces++;
10            }
11        }
12
13        return provinces;        
14    }
15
16    private void dfs(int city, int[][] isConnected, Set<Integer> visited) {
17        visited.add(city);
18        for (int cur = 0; cur < isConnected[city].length; cur++) {
19            int connected = isConnected[city][cur];
20            if (connected == 1 && !visited.contains(cur)) {
21                dfs(cur, isConnected, visited);
22            }
23        }
24    }    
25}