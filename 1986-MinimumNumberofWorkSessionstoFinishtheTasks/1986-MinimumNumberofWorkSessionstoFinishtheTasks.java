// Last updated: 1/13/2026, 7:47:11 PM
1class Solution {
2    int ans;
3
4    public int minSessions(int[] tasks, int sessionTime) {
5        Arrays.sort(tasks);                 
6        ans = tasks.length;
7        dfs(tasks, tasks.length - 1, new int[tasks.length], 0, sessionTime);
8        return ans;
9    }
10
11    private void dfs(int[] tasks, int idx, int[] sessions, int count, int limit) {
12        if (count >= ans) return;            
13        if (idx < 0) {
14            ans = Math.min(ans, count);
15            return;
16        }
17
18        for (int i = 0; i < count; i++) {
19            if (sessions[i] + tasks[idx] <= limit) {
20                sessions[i] += tasks[idx];
21                dfs(tasks, idx - 1, sessions, count, limit);
22                sessions[i] -= tasks[idx];
23            }
24        }
25 
26        sessions[count] = tasks[idx];
27        dfs(tasks, idx - 1, sessions, count + 1, limit);
28        sessions[count] = 0;
29    }
30}
31