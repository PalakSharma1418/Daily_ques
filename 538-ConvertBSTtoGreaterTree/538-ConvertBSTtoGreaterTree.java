// Last updated: 8/21/2025, 10:36:55 AM
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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
         gst(root);
        return root;
    }
    public void gst(TreeNode root) {
        if(root == null) return ;

        gst(root.right);
        sum=sum+root.val;
        root.val = sum;
        gst(root.left);
    }
}
