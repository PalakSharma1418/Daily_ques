// Last updated: 9/27/2025, 7:54:09 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        if(k==1){
            return nums;
        }

        Deque<Integer> deque = new ArrayDeque<>(); // store indices
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int start = 0;

        // Process first k elements
        for (int i = 0; i < k; i++) {
            // dequeue mai hum sorted descending store kar rhe hai
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {//last current se choota hai so remove
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process the rest
        for (int i = k; i < n; i++) {
            // The front is the max of the previous window
            ans[start++] = nums[deque.getFirst()];

            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }

            // Maintain decreasing order in deque
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Add max for the last window
        ans[start] = nums[deque.getFirst()];

        return ans;
}
}
