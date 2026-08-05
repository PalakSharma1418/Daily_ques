// Last updated: 8/6/2026, 4:28:23 AM
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
17    public boolean isCousins(TreeNode root, int A, int B) {
18    if (root == null) return false;
19	Queue<TreeNode> queue = new LinkedList<>();
20	queue.offer(root);
21	while (!queue.isEmpty()) {
22		int size = queue.size();
23		boolean isAexist = false;		
24		boolean isBexist = false;		
25		for (int i = 0; i < size; i++) {
26			TreeNode cur = queue.poll();
27            if (cur.val == A) isAexist = true;
28            if (cur.val == B) isBexist = true;
29			if (cur.left != null && cur.right != null) { 
30				if (cur.left.val == A && cur.right.val == B) { 
31					return false;
32				}
33				if (cur.left.val == B && cur.right.val == A) { 
34					return false;
35				}
36			}
37			if (cur.left != null) {
38				queue.offer(cur.left);
39			}
40			if (cur.right != null) {
41				queue.offer(cur.right);
42			}
43		}
44		if (isAexist && isBexist)  return true;
45	}
46	return false;
47}
48}