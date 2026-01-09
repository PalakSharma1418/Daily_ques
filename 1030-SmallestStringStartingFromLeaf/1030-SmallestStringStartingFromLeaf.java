// Last updated: 1/9/2026, 10:58:09 AM
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
    // Map node values (0–25) to characters 'a'–'z'
    char[] alphabets = {
        'a','b','c','d','e','f','g','h','i','j',
        'k','l','m','n','o','p','q','r','s','t',
        'u','v','w','x','y','z'
    };

    public String smallestFromLeaf(TreeNode root) {
        List<String> ll = new ArrayList<>();
        help(root, ll, new StringBuilder());
        Collections.sort(ll); 
        return ll.get(0);
    }

    public void help(TreeNode root, List<String> ll, StringBuilder sb) {
        if (root == null) return;

        // prepend current char at the front
        sb.insert(0, alphabets[root.val]);

        if (root.left == null && root.right == null) {
            // make a copy of current StringBuilder
            ll.add(sb.toString());
        } else {
            help(root.left, ll, sb);
            help(root.right, ll, sb);
        }

        // backtrack: remove first char before returning
        sb.deleteCharAt(0);//string mai hum copy bana rhe the yha nhi 
    }
}