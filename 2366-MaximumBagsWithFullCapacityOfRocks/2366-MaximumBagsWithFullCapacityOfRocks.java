// Last updated: 8/6/2025, 4:43:25 PM

public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] required = new int[n];
        
        for (int i = 0; i < n; i++) {
            required[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(required);

        int filledBags = 0;
        for (int i = 0; i < n; i++) {
            if (required[i] == 0) {
                filledBags++; 
            } else if (required[i] <= additionalRocks) {
                additionalRocks -= required[i];
                filledBags++;
            } else {
                break; // not enough rocks to fill the next bag
            }
        }

        return filledBags;
    }
}
// binary search ki beat kam thi bo bhi kiya tha