// Last updated: 2/24/2026, 7:39:30 PM
1class Solution {
2    
3    public int sumRootToLeaf(TreeNode root) {
4        return dfs(root, 0);
5    }
6    
7    private int dfs(TreeNode node, int current) {
8        if (node == null) {
9            return 0;
10        }
11        
12        current = current * 2 + node.val;
13        
14        if (node.left == null && node.right == null) {
15            return current;
16        }
17        
18        return dfs(node.left, current) + dfs(node.right, current);
19    }
20}