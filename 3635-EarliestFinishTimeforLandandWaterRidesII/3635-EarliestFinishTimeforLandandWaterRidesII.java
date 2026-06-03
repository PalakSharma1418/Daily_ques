// Last updated: 6/3/2026, 7:18:05 PM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3        return Math.min(
4            calFinishTime(landStartTime,landDuration,waterStartTime,waterDuration),
5            calFinishTime(waterStartTime,waterDuration,landStartTime,landDuration)
6        );
7    }
8     private int calFinishTime(int[] ls, int[] ld,int[] ws, int[] wd) {
9
10        int mini = Integer.MAX_VALUE;
11
12        for (int i = 0; i < ls.length; i++) {
13            mini = Math.min(mini, ls[i] + ld[i]);
14        }
15
16        int ans = Integer.MAX_VALUE;
17
18        for (int i = 0; i < ws.length; i++) {
19            ans = Math.min(
20                ans,
21                Math.max(mini, ws[i]) + wd[i]
22            );
23        }
24
25        return ans;
26    }
27}