// Last updated: 8/6/2025, 4:50:02 PM
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode last = root;
        TreeNode nlast = null;
        List<Integer> level = new ArrayList<>();
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            TreeNode rv = q.remove();
            level.add(rv.val);

            if (rv.left != null) {
                q.add(rv.left);
                nlast = rv.left;
            }

            if (rv.right != null) {
                q.add(rv.right);
                nlast = rv.right;
            }

            if (rv == last) {
                if (!leftToRight) {
                    Collections.reverse(level); // reverse if right-to-left
                }

                ans.add(level); // add the current level
                level = new ArrayList<>(); // reset
                last = nlast;
                leftToRight = !leftToRight; // flip direction
            }
        }

        return ans;
    }
}
