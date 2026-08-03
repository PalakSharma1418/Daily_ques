// Last updated: 8/3/2026, 7:35:07 PM
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
17    public List<Double> averageOfLevels(TreeNode root) {
18        Queue<TreeNode> q = new LinkedList<>(List.of(root));
19        List<Double> ans = new ArrayList<>();
20        while (q.size() > 0) {
21            double qlen = q.size(), row = 0;
22            for (int i = 0; i < qlen; i++) {
23                TreeNode curr = q.poll();
24                row += curr.val;
25                if (curr.left != null) q.offer(curr.left);
26                if (curr.right != null) q.offer(curr.right);
27            }
28            ans.add(row/qlen);
29        }
30        return ans;
31    }
32}