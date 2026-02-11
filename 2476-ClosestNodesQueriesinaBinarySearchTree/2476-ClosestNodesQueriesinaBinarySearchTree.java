// Last updated: 2/11/2026, 3:59:16 PM
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
17    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
18        List<Integer> list = new ArrayList<>();
19        inorder(list, root);
20        List<List<Integer>> res = new ArrayList<>();
21        for (int q : queries){
22            res.add(binarySearch(list, q));
23        }
24        return res;
25    }
26    private List<Integer> binarySearch(List<Integer> list, int n){
27        int low = 0;
28        int high = list.size() - 1;
29        int min = -1;
30        int max = -1;
31        while (low <= high){
32            int mid = low + (high - low) / 2;
33            int temp = list.get(mid);
34            if (temp == n){
35                min = temp;
36                max = temp;
37                break;
38            }
39            else if (temp < n){
40                min = temp;
41                low = mid + 1;
42            }
43            else{
44                max = temp;
45                high = mid - 1;
46            }
47        }
48        List<Integer> res = new ArrayList<>();
49        res.add(min);
50        res.add(max);
51        return res;
52    }
53    private void inorder(List<Integer> res, TreeNode root){
54        if (root == null) return;
55        inorder(res, root.left);
56        res.add(root.val);
57        inorder(res, root.right);
58
59    }
60}