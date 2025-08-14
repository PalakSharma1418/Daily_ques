// Last updated: 8/14/2025, 10:17:02 AM
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
    int camera=0;
    public int minCameraCover(TreeNode root) {
          int c= minCamera(root);
          if(c == -1){
            camera++;
          }
          return camera;
    }
    public int minCamera(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = minCamera(root.left);
        int right = minCamera(root.right);
        if(left ==-1 || right ==-1){//is node par need hai camera
            camera++;
            return 1; // camera setup kara hai yha
        }
        if(left==1 || right==1){ 
            // inmai se koi ek pass camera ya dono ke pass hai and dusra bala covered hai
            return 0;//covered
        }
        else{
            return -1;
            //kyuki dono child to cover hai lekin mujhe requirement hai
        }
    }
}