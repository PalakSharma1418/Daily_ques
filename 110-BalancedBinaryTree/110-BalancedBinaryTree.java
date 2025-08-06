// Last updated: 8/6/2025, 4:49:58 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancePair {
    boolean isbal = true;
    int ht = -1;
}

public class Solution {

    public boolean isBalanced(TreeNode root) {
        BalancePair bp = isBalance(root);
        return bp.isbal;
    }

    public BalancePair isBalance(TreeNode root) {
        if (root == null) return new BalancePair();

        BalancePair ldp = isBalance(root.left);
        BalancePair rdp = isBalance(root.right);

        BalancePair sbp = new BalancePair();
        sbp.ht = Math.max(ldp.ht, rdp.ht) + 1;

        boolean selfBal = Math.abs(ldp.ht - rdp.ht) <= 1;

        sbp.isbal = ldp.isbal && rdp.isbal && selfBal;

        return sbp;
    }
}
