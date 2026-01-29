// Last updated: 1/29/2026, 6:40:32 PM
1class Solution {
2
3    private boolean check(long mid, long[] diff, int r, long k, int n) {
4        long[] tempDiff = Arrays.copyOf(diff, n);
5        long cumSum = 0;
6        for (int i = 0; i < n; i++) {
7            cumSum += tempDiff[i];
8            if (cumSum < mid) {
9                long need = mid - cumSum;
10                if (need > k) {
11                    return false;
12                }
13                k -= need;
14                cumSum += need;
15                // apply difference array logic
16                // kyuki na i to kam hai hum i+r par rkhte hai taki (jyda range mai benfite ho ) i+r par rkha to i---i+r---i+r+r
17                if (i + 2L * r + 1 < n) {
18                    tempDiff[(int)(i + 2L * r + 1)] -= need;
19                }
20            }
21        }
22        return true;
23    }
24
25    public long maxPower(int[] stations, int r, int k) {
26        int n = stations.length;
27        long[] diff = new long[n];
28
29        // Build difference array
30        for (int i = 0; i < n; i++) {
31            int left = Math.max(0, i - r);
32            int right = i + r + 1;
33            diff[left] += stations[i];
34            if (right < n) diff[right] -= stations[i];
35        }
36
37        long left = Arrays.stream(stations).min().getAsInt();
38        long right = Arrays.stream(stations).asLongStream().sum() + k;
39        long result = 0;
40
41        // Binary search
42        while (left <= right) {
43            long mid = left + (right - left) / 2;
44            if (check(mid, diff, r, k, n)) {
45                result = mid;
46                left = mid + 1;
47            } else {
48                right = mid - 1;
49            }
50        }
51        return result;
52    }
53}
54// https://chatgpt.com/c/690dfa9c-cbdc-8324-86da-ca51fe05825e