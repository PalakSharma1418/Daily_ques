// Last updated: 5/17/2026, 6:51:47 PM
1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        boolean[] visited = new boolean[arr.length];
4        return help(arr, start, visited);
5    }
6
7    public boolean help(int[] arr, int i, boolean[] visited) {
8        if (i < 0 || i >= arr.length) {
9            return false;
10        }
11        if (visited[i]) {
12            return false;
13        }
14        if (arr[i] == 0) {
15            return true;
16        }
17
18        visited[i] = true;
19
20        return help(arr, i + arr[i], visited) ||
21               help(arr, i - arr[i], visited);
22    }
23}