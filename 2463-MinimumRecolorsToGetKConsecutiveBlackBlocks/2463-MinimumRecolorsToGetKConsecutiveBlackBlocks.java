// Last updated: 8/6/2025, 4:43:10 PM
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minRecolors = Integer.MAX_VALUE;
        int whiteCount = 0;
        
        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        minRecolors = whiteCount;
        
        // Sliding window: Move the window forward
        for (int i = k; i < blocks.length(); i++) {
            // Remove the leftmost element of the window
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Add the new rightmost element
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            minRecolors = Math.min(minRecolors, whiteCount);
        }
        
        return minRecolors;
    }
}
