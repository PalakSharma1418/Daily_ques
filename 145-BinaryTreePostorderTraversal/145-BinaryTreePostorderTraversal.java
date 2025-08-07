// Last updated: 8/7/2025, 10:53:26 AM
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
    public List<Integer> postorderTraversal(TreeNode root) {
             List<Integer> ll = new ArrayList<>();
        p(root,ll);
        return ll;
    }
    public void p(TreeNode root,  List<Integer> ll){
        if(root== null) return;
       
        p(root.left,ll);
        p(root.right,ll);
         ll.add(root.val);
    }
}