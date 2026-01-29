// Last updated: 1/29/2026, 7:58:30 PM
1// class Solution {
2//     public int maxFrequency(int[] nums, int k) {
3//         int n = nums.length;
4
5//         int alreadyK = 0;
6//         for (int num : nums) {
7//             if (num == k) alreadyK++;
8//         }
9
10//         int[] diff = new int[n];
11//         for (int i = 0; i < n; i++) {
12//             diff[i] = k - nums[i];
13//         }
14
15//         HashMap<Integer, Integer> map = new HashMap<>();
16//         int maxLen = 0;
17
18//         for (int i = 0; i < n; i++) {
19//             if (diff[i] == 0) {
20//                 map.clear();   // subarray break
21//                 continue;
22//             }
23
24//             map.put(diff[i], map.getOrDefault(diff[i], 0) + 1);
25//             maxLen = Math.max(maxLen, map.get(diff[i]));
26//         }
27
28//         return alreadyK + maxLen;
29//     }
30// }
31class Solution {
32    public int  maxFrequency(int[] nums, int k) {
33        int n = nums.length;
34        int alreadyK = 0;
35
36        for (int num : nums) {
37            if (num == k) alreadyK++;
38        }
39
40        int answer = alreadyK;
41
42        // nums[i] ∈ [1..50], k ∈ [1..50]
43        for (int x = -50; x <= 50; x++) {
44            if (x == 0) continue;
45
46            int curr = 0, best = 0;
47
48            for (int num : nums) {
49                if (k - num == x) {
50                    curr += 1;
51                } else if (num == k) {
52                    curr -= 1;
53                }
54
55                if (curr < 0) curr = 0;
56                best = Math.max(best, curr);
57            }
58
59            answer = Math.max(answer, alreadyK + best);
60        }
61
62        return answer;
63    }
64}
65