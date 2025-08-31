// Last updated: 8/31/2025, 4:27:36 PM
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ll = new ArrayList<>();
        add(root1,ll);
        add(root2,ll);
        Collections.sort(ll);
        return ll;
    }
    public void add(TreeNode root , List<Integer> ll){
        if(root==null ) return;
        // if(root.left == null && root.right == null){
            ll.add(root.val);
        //     return;
        // }

        add(root.left,ll);
        add(root.right,ll);
    }
}