// Last updated: 12/16/2025, 2:48:50 PM
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
17    public List<Integer> inorderTraversal(TreeNode root) {
18        List<Integer> res = new ArrayList<>();
19
20        inorder(root, res);
21        return res;        
22    }
23
24    private void inorder(TreeNode node, List<Integer> res) {
25        if (node == null) {
26            return;
27        }
28        inorder(node.left, res);
29        res.add(node.val);
30        inorder(node.right, res);
31    }    
32}