// Last updated: 2/8/2026, 10:58:22 AM
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
16class BalancePair {
17    boolean isbal = true;
18    int ht = -1;
19}
20
21public class Solution {
22
23    public boolean isBalanced(TreeNode root) {
24        BalancePair bp = isBalance(root);
25        return bp.isbal;
26    }
27
28    public BalancePair isBalance(TreeNode root) {
29        if (root == null) return new BalancePair();
30
31        BalancePair ldp = isBalance(root.left);
32        BalancePair rdp = isBalance(root.right);
33
34        BalancePair sbp = new BalancePair();
35        sbp.ht = Math.max(ldp.ht, rdp.ht) + 1;
36
37        boolean selfBal = Math.abs(ldp.ht - rdp.ht) <= 1;
38
39        sbp.isbal = ldp.isbal && rdp.isbal && selfBal;
40
41        return sbp;
42    }
43}
44