// Last updated: 9/15/2025, 7:49:07 PM
class KthLargest {
// The smallest element in the heap (peek()) is the kth largest. 4 ki heap to 4th largest sabse chota 
    private PriorityQueue<Integer> minHeap; 
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        // If heap grows beyond k, remove the smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */