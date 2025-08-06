// Last updated: 8/6/2025, 4:49:59 PM
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Track when a level ends
        TreeNode last = root;        // last node of current level
        TreeNode nlast = null;       // will track last node of next level

        List<Integer> level = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode rv = q.remove();
            level.add(rv.val);

            if (rv.left != null) {
                q.add(rv.left);
                nlast = rv.left;     // update potential end of next level
            }
            if (rv.right != null) {
                q.add(rv.right);
                nlast = rv.right;    // update potential end of next level
            }

            if (rv == last) {
                ans.add(level);      // finished one level
                level = new ArrayList<>(); // reset for next level
                last = nlast;        // move to next level's last
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}