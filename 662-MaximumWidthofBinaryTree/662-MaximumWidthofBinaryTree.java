// Last updated: 8/15/2025, 12:26:29 PM
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
 class Pair{
            TreeNode node;
            int idx;
            public Pair(TreeNode node,int idx){
                this.idx= idx;
                this.node= node;
            }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int width=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair start=q.peek();
            int s=q.size();
            Pair end=null;
            for(int i=0;i<s;i++){
                end=q.poll();
                if(end.node.left !=null){
                    q.add(new Pair(end.node.left , 2*end.idx+1));
                }
                if(end.node.right !=null){
                    q.add(new Pair(end.node.right , 2*end.idx+2));
                }
            }
            width=Math.max(width,end.idx-start.idx+1);
        }
        return width;
    }
}