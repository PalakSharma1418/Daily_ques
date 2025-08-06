// Last updated: 8/6/2025, 4:49:52 PM
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        // hasset mai bina duplicate ke number add hote ja rhe hai
        for (int num : set) {
            // only start from the beginning of a sequence
            // mtlb agr 2 aya ti hm nhi cont kare kyuki 1 exsist karta hai
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {// jab tak ata jaye consecutively
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
