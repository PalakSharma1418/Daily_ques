// Last updated: 1/6/2026, 6:18:32 AM
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
16import java.util.*;
17
18class Solution {
19    public int maxLevelSum(TreeNode root) {
20        Queue<TreeNode> q = new LinkedList<>();
21        q.add(root);
22
23        int maxSum = Integer.MIN_VALUE;
24        int ansLevel = 0;
25        int level = 0;
26
27        while (!q.isEmpty()) {
28            int size = q.size();
29            int sum = 0;
30            level++;
31
32            for (int i = 0; i < size; i++) {
33                TreeNode node = q.poll();
34                sum += node.val;
35
36                if (node.left != null) q.add(node.left);
37                if (node.right != null) q.add(node.right);
38            }
39
40            if (sum > maxSum) {
41                maxSum = sum;
42                ansLevel = level;
43            }
44        }
45
46        return ansLevel;
47    }
48}
49