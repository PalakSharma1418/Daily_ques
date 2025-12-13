// Last updated: 12/13/2025, 7:15:11 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public static void inorder(ArrayList<TreeNode>ans,TreeNode root){
18        if(root==null){
19            return;
20        }
21        inorder(ans,root.left);
22        ans.add(root);
23        inorder(ans,root.right);
24    }
25    public static TreeNode tree(ArrayList<TreeNode>ans,int i){
26        if(i==ans.size()){
27            return null;
28        }
29        TreeNode root=ans.get(i);
30        root.left=null;
31        root.right=tree(ans,i+1);
32        return root;
33    }
34    public TreeNode increasingBST(TreeNode root) {
35        ArrayList<TreeNode>ans=new ArrayList<>();
36        inorder(ans,root);
37        return tree(ans,0);
38    }
39}