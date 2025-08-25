// Last updated: 8/25/2025, 8:24:49 AM
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
    int ans=0,l=-1;
    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null && root.right==null){
            return root.val;
        }
        bst(root,0);
        return ans;
    }
    public void bst(TreeNode root , int level){
        if(root == null) return;

        if(level>l){
            l=level;
            ans=root.val;
        }

        bst(root.left, level+1);
        bst(root.right, level+1);

    }
}