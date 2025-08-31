// Last updated: 8/31/2025, 4:27:33 PM
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
    public int maxSumBST(TreeNode root) {
        return ValidBST(root).ans;
    }
    class bstPair{
        boolean isbst=true;
        Long max=Long.MIN_VALUE;
        Long min=Long.MAX_VALUE;
        int sum=0;
        int ans=0;//bst part ka sum
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
        sdp.sum=ldp.sum+rdp.sum+root.val;
        if(sdp.isbst){
            sdp.ans = Math.max(ldp.ans,Math.max(rdp.ans, sdp.sum));
        }
        else{
            sdp.ans = Math.max(ldp.ans,rdp.ans);
        }
        return sdp; 
    }
}