// Last updated: 1/31/2026, 4:51:19 PM
1class Solution {
2
3    int answer = Integer.MAX_VALUE;
4    public int findMinimumTime(List<Integer> strength, int k)  {
5        boolean[] used = new boolean[strength.size()];
6        dfs(strength, used, 1, 0, k);
7        return answer;
8    }
9    void dfs(List<Integer> strength, boolean[] used, int x, int time, int k) {
10        if (allUsed(used)) {
11            answer = Math.min(answer, time);
12            return;
13        }
14
15        for (int i = 0; i < strength.size(); i++) {
16            if (!used[i]) {
17                int neededTime = (strength.get(i) + x - 1) / x; // ceil
18                used[i] = true;
19                dfs(strength, used, x + k, time + neededTime, k);
20                used[i] = false; 
21            }
22        }
23    }
24
25    boolean allUsed(boolean[] used) {
26        for (boolean b : used) {
27            if (!b) return false;
28        }
29        return true;
30    }
31}
32