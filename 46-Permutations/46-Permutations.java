// Last updated: 8/6/2025, 4:50:58 PM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> f = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // Track used elements
        permutation(nums, ll, f, used);
        return f;
    }
    public static void permutation(int[] nums, List<Integer> ll, List<List<Integer>> f, boolean[] used) {
        if (ll.size() == nums.length) {
            f.add(new ArrayList<>(ll));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // Ensure each number is used only once
                used[i] = true;
                ll.add(nums[i]);
                permutation(nums, ll, f, used);
                ll.remove(ll.size() - 1);
                used[i] = false;
            }
        }
    }
}