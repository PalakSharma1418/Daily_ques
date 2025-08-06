// Last updated: 8/6/2025, 4:45:12 PM
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); 
        int lo = 1; 
        int hi = position[position.length - 1] - position[0]; 
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; 
            
            if (canPlaceBalls(position, m, mid)) {
                ans = mid; 
                lo = mid + 1;
            } else {
                hi = mid - 1; 
            }
        }
        return ans;
    }
    public static  boolean canPlaceBalls(int[] position, int m, int minForce) {
        int count = 1;
        int lastPosition = position[0]; 
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minForce) {
                count++; 
                lastPosition = position[i]; 
            }
            if (count == m) {
                return true;
            }
        }
        return false; 
    }
}