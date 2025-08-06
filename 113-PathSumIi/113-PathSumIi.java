// Last updated: 8/6/2025, 4:49:55 PM
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) return;

        path.add(node.val);

        // Check if it's a leaf and path sum is target
        if (node.left == null && node.right == null && targetSum == node.val) {
            ans.add(new ArrayList<>(path)); // store copy of path
        } else {
            dfs(node.left, targetSum - node.val, path, ans);
            dfs(node.right, targetSum - node.val, path, ans);
        }

        path.remove(path.size() - 1); // backtrack
    }
}

