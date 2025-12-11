// Last updated: 12/11/2025, 7:35:17 AM
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