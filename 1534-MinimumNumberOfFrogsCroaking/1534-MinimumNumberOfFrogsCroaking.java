// Last updated: 8/6/2025, 4:45:30 PM
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5]; // For 'c', 'r', 'o', 'a', 'k'
        int frogs = 0;
        int maxFrogs = 0;
        
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                count[0]++;
                frogs++;  // A new frog started croaking
                maxFrogs = Math.max(maxFrogs, frogs);
            } else if (ch == 'r') {
                if (count[0] == 0) return -1;
                count[0]--;
                count[1]++;
            } else if (ch == 'o') {
                if (count[1] == 0) return -1;
                count[1]--;
                count[2]++;
            } else if (ch == 'a') {
                if (count[2] == 0) return -1;
                count[2]--;
                count[3]++;
            } else if (ch == 'k') {
                if (count[3] == 0) return -1;
                count[3]--;
                frogs--; // One frog finishes croaking
            } else {
                return -1; // Invalid character
            }
        }

        // At the end, all croaks should be finished
        if (frogs == 0) return maxFrogs;
        return -1;
    }
}

// -1 jab return kar rhe mano r hai c nhi hai to crock kese hoga
// We subtract counts when a frog advances to next stage.

// If no frog is available in a previous stage, that means an invalid croak sequence, so we return -1.

