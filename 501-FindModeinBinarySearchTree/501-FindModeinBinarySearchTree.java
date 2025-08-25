// Last updated: 8/25/2025, 8:25:43 AM
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
    public int[] findMode(TreeNode root) {
         HashMap<Integer,Integer> map=new HashMap<>();
        func(root,map);
        int maxval=0;
        List<Integer> ll=new ArrayList<>();
        for(int ele:map.keySet()){
                if(map.get(ele)>maxval){
                    ll.clear();
                    ll.add(ele);
                    maxval=map.get(ele);
                }
               else if(map.get(ele)==maxval){
                    ll.add(ele);

                }
        }
        return ll.stream().mapToInt(Integer::intValue).toArray();
    }
     public void func(TreeNode root,HashMap<Integer,Integer> map){
        if(root==null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        func(root.left,map);
        func(root.right,map);


    }
}