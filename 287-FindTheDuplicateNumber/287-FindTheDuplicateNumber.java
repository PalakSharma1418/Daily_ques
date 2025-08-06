// Last updated: 8/6/2025, 4:48:40 PM
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Find the intersection point of the two pointers
        // liked list cyco
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // floyeds algo
        
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
