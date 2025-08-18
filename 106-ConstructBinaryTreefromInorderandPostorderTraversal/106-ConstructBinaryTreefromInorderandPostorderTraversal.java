// Last updated: 8/18/2025, 7:41:00 PM
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode createTree(int[] in, int[] post, int ilo, int ihi, int plo, int phi) {
        if (ilo > ihi || plo > phi) {
            return null;
        }

        // root is always the last element in postorder
        TreeNode node = new TreeNode(post[phi]);

        // find root in inorder
        int idx = search(in, ilo, ihi, post[phi]);
        int count = idx - ilo; // number of nodes in left subtree

        // build left subtree
        node.left = createTree(in, post, ilo, idx - 1, plo, plo + count - 1);

        // build right subtree
        node.right = createTree(in, post, idx + 1, ihi, plo + count, phi - 1);

        return node;
    }

    private int search(int[] in, int ilo, int ihi, int item) {
        for (int i = ilo; i <= ihi; i++) {
            if (in[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
