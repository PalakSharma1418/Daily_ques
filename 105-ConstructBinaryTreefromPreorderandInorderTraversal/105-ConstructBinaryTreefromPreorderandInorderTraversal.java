// Last updated: 8/13/2025, 10:51:23 AM
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    public TreeNode createTree(int[] in, int[] pre, int ilo, int ihi, int plo, int phi) {
        if (ilo > ihi || plo > phi) {
            return null;
        }

        TreeNode node = new TreeNode(pre[plo]); // root is always first element in preorder
        int idx = search(in, ilo, ihi, pre[plo]); // find root in inorder
        int count = idx - ilo; // number of nodes in left subtree

        // build left subtree
        node.left = createTree(in, pre, ilo, idx - 1, plo + 1, plo + count);
        
        // build right subtree
        node.right = createTree(in, pre, idx + 1, ihi, plo + count + 1, phi);

        return node;
    }

    public int search(int[] in, int ilo, int ihi, int item) {
        for (int i = ilo; i <= ihi; i++) {
            if (in[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
