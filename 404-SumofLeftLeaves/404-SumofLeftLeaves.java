// Last updated: 8/11/2025, 7:33:31 PM
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
class Solution {
    int sum = 0;
    public void rec(TreeNode root, boolean isLeft) {
        if(root==null) return;
        if(root.left==null && root.right==null && isLeft==true) {
            sum+=root.val;
            return;
        }
        rec(root.left, true);
        rec(root.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        boolean isLeft = false;
        rec(root,isLeft);
        return sum;
        
    }
}