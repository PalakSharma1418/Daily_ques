// Last updated: 1/3/2026, 5:09:39 AM
1// class Solution {
2//     int total = 0;
3
4//     public int pathSum(TreeNode root, int targetSum) {
5//         if (root == null) return 0;
6
7//         path(root, targetSum, 0L);   // 👈 long
8//         pathSum(root.left, targetSum);
9//         pathSum(root.right, targetSum);
10
11//         return total;
12//     }
13
14//     public void path(TreeNode root, int targetSum, long curr) {
15//         if (root == null) return;
16
17//         curr += root.val;            // safe now
18
19//         if (curr == targetSum) {
20//             total++;
21//         }
22
23//         path(root.left, targetSum, curr);
24//         path(root.right, targetSum, curr);
25//     }
26// }
27class Solution {
28    int total = 0;
29
30    public int pathSum(TreeNode root, int targetSum) {
31        if (root == null) return 0;
32
33        HashMap<Long, Integer> hm = new HashMap<>(); // 👈 Long key
34        hm.put(0L, 1);                               // 👈 0L
35
36        findPathSum(root, 0L, targetSum, hm);        // 👈 long sum
37        return total;
38    }
39
40    private void findPathSum(TreeNode curr, long sum, int target,
41                             HashMap<Long, Integer> hm) {
42        if (curr == null) return;
43
44        sum += curr.val; // 👈 safe (long + int)
45
46        if (hm.containsKey(sum - target)) {
47            total += hm.get(sum - target);
48        }
49
50        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
51
52        findPathSum(curr.left, sum, target, hm);
53        findPathSum(curr.right, sum, target, hm);
54
55        hm.put(sum, hm.get(sum) - 1); // backtrack
56    }
57}
58