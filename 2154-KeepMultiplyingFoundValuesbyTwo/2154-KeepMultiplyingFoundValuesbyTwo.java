// Last updated: 11/19/2025, 5:21:25 PM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int value = original;
        while (set.contains(value)) {
            value *= 2;
        }
        return value;
    }
}