// Last updated: 8/26/2025, 11:06:22 AM
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
    public boolean isUnivalTree(TreeNode root) {
        int i = root.val;
        return func(root , i);
    }
    public boolean func(TreeNode root, int val){
        if(root == null ) return true;

        if(root.val!=val){
            return false;
        }
        
        boolean l = func(root.left, val);
        boolean r = func(root.right , val);
        return l && r;
    }
}