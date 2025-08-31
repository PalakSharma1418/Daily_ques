// Last updated: 8/31/2025, 4:27:28 PM
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
    public int goodNodes(TreeNode root) {
        return Nodes(root,root.val);
    }
    public int Nodes(TreeNode root , int prev ) {
        if(root == null ) return 0;
         int ans=0;
        if(root.val>=prev){
            ans=1;
        }
        int newMax = Math.max(prev, root.val);
        ans += Nodes(root.left, newMax);
        ans += Nodes(root.right, newMax);
        return ans;

// [5,1,null,2]
    }
}