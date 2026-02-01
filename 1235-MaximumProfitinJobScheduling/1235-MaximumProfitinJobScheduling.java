// Last updated: 2/1/2026, 2:21:38 PM
1class Solution {
2    private int[] memo;
3    private int n;
4
5    // Find the first job whose starting point >= currentJob's end point
6    private int getNextIndex(int[][] array, int l, int currentJobEnd) {
7        int r = n - 1;
8        int result = n + 1;
9
10        while (l <= r) {
11            int mid = l + (r - l) / 2;
12
13            if (array[mid][0] >= currentJobEnd) { // we can take this task
14                result = mid;
15                r = mid - 1;
16            } else {
17                l = mid + 1;
18            }
19        }
20
21        return result;
22    }
23
24    private int solve(int[][] array, int i) {
25        if (i >= n)
26            return 0;
27
28        if (memo[i] != -1)
29            return memo[i];
30
31        int next = getNextIndex(array, i + 1, array[i][1]);
32
33        int taken = array[i][2] + solve(array, next);
34        int notTaken = solve(array, i + 1);
35
36        return memo[i] = Math.max(taken, notTaken);
37    }
38
39    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
40        n = startTime.length;
41
42        memo = new int[n];
43        Arrays.fill(memo, -1);
44
45        int[][] array = new int[n][3]; // {s, e, p}
46
47        for (int i = 0; i < n; i++) {
48            array[i][0] = startTime[i];
49            array[i][1] = endTime[i];
50            array[i][2] = profit[i];
51        }
52
53        Arrays.sort(array, Comparator.comparingInt(vec -> vec[0]));
54
55        return solve(array, 0);
56    }
57}
58