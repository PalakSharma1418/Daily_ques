// Last updated: 2/16/2026, 12:18:31 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16/**
17 * Definition for a binary tree node.
18 * public class TreeNode {
19 *     int val;
20 *     TreeNode left;
21 *     TreeNode right;
22 *     TreeNode() {}
23 *     TreeNode(int val) { this.val = val; }
24 *     TreeNode(int val, TreeNode left, TreeNode right) {
25 *         this.val = val;
26 *         this.left = left;
27 *         this.right = right;
28 *     }
29 * }
30 */
31class Solution {
32
33    int max = Integer.MIN_VALUE;
34
35    public int maxPathSum(TreeNode root) {
36        dfs(root);
37        return max;
38    }
39
40    private int dfs(TreeNode root) {
41        if (root == null) return 0;
42
43        int left = Math.max(0, dfs(root.left));
44        int right = Math.max(0, dfs(root.right));
45
46        // V-shape path
47        int current = root.val + left + right;
48
49        max = Math.max(max, current);
50
51        // Return straight path
52        return root.val + Math.max(left, right);
53    }
54}
55