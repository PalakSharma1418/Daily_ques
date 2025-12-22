// Last updated: 12/22/2025, 4:05:23 PM
1// class Solution {
2//     public int minDeletionSize(String[] strs) {
3//         int count = 0;
4//         int rows = strs.length;
5//         int cols = strs[0].length();
6//         for (int j = 0; j < cols; j++) {
7//             for (int i = 0; i < rows - 1; i++) {
8//                 if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
9//                     count++;     
10//                     break;       
11//                 }
12//             }
13//         }
14//         return count;
15//     }
16// }
17class Solution {
18    public int minDeletionSize(String[] strs) {
19
20        int n = strs.length;
21        int m = strs[0].length();
22        int deletions = 0;
23
24        boolean[] sorted = new boolean[n - 1];
25
26        for (int j = 0; j < m; j++) {
27
28            boolean badColumn = false;
29
30            // Step 1: check if column breaks order
31            for (int i = 0; i < n - 1; i++) {
32                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
33                    deletions++;
34                    badColumn = true;
35                    break;
36                }
37            }
38
39            // Step 2: update sorted pairs if column is good
40            if (!badColumn) {
41                for (int i = 0; i < n - 1; i++) {
42                    if (!sorted[i] && strs[i].charAt(j) < strs[i + 1].charAt(j)) {
43                        sorted[i] = true;
44                    }
45                }
46            }
47        }
48        return deletions;
49    }
50}
51