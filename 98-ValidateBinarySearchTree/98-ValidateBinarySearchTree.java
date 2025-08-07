// Last updated: 8/7/2025, 12:09:47 PM
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
    class bstPair{
        boolean isbst=true;
        Long max=Long.MIN_VALUE;
        Long min=Long.MAX_VALUE;
    }
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root).isbst;
    }
    public bstPair ValidBST(TreeNode root){
        if(root == null){
            return new bstPair();
        }

        bstPair ldp= ValidBST(root.left);
        bstPair rdp= ValidBST(root.right);
        bstPair sdp= new bstPair();
        sdp.min = Math.min(ldp.min , Math.min(rdp.min,root.val));
        sdp.max = Math.max(ldp.max , Math.max(rdp.max, root.val));
        sdp.isbst = ldp.isbst && rdp.isbst && ldp.max<root.val && rdp.min>root.val;
        return sdp; 
    }
}