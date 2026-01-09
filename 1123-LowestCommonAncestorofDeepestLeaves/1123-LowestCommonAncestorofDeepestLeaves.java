// Last updated: 1/9/2026, 6:07:44 PM
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
16class Solution {
17    HashMap<TreeNode,Integer> map = new HashMap<>();
18    int maxd = 0;
19
20    public TreeNode lcaDeepestLeaves(TreeNode root) {
21        depth(root, 0);
22        return lca(root);
23    }
24
25    void depth(TreeNode root, int d) {
26        if (root == null) return;
27        map.put(root, d);
28        maxd = Math.max(maxd, d);
29        depth(root.left, d + 1);
30        depth(root.right, d + 1);
31    }
32
33    TreeNode lca(TreeNode root) {
34        if (root == null || map.get(root) == maxd) {
35            return root;
36        }
37
38        TreeNode left = lca(root.left);
39        TreeNode right = lca(root.right);
40
41        if (left != null && right != null) return root;
42        return left != null ? left : right;
43    }
44}