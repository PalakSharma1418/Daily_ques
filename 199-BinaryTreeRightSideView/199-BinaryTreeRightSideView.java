// Last updated: 8/6/2025, 4:49:18 PM
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
    private int max_depth; // to track the maximum depth visited

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        max_depth = -1; // initialize before starting traversal
        RightView(root, 0, result);
        return result;
    }
    public void RightView(TreeNode root, int curr_level , List<Integer> ll){
        if(root==null){
            return;
        }
        if(max_depth<curr_level){
            ll.add(root.val);
            max_depth=curr_level;
        }
        RightView(root.right , curr_level+1,ll);
        RightView(root.left,curr_level+1,ll);
    }
}