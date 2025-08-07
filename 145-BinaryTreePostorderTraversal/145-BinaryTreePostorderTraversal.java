// Last updated: 8/7/2025, 11:42:16 AM
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
				return null;
		}
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left= deleteNode(root.left, key);
        }
        else{
            // 0 and 1 
            if(root.left==null) return root.right;
            else if(root.right == null) return root.left;
            // 2 
            else{
// left ka max   or right ka min
            int max = max(root.left);
			root.left = deleteNode(root.left, max);
			root.val = max;
            }
        }
        return root;
    }
    public int max(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE; 
        }

        int max= max(root.right);
        return Math.max(max,root.val);
    }
}