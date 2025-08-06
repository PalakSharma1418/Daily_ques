// Last updated: 8/6/2025, 4:41:45 PM
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int totalGroups = 0;
        int start = 0;
        int end = 0;
        int lastColor = -1;
        int n = colors.length;
        while (start < n && end < n + k) {
            int currentIndex = end % n; // Handle circular indexing
            // Reset window if consecutive colors are the same
            if (colors[currentIndex] == lastColor) {
                start = end;
            }
            // Check if we have a valid alternating sequence of size k
            if (end - start + 1 == k) {
                totalGroups++;
                start++; // Move start to check the next window
            }
            end++;
            lastColor = colors[currentIndex]; // Update last seen color
        }

        return totalGroups;
    }
} 
