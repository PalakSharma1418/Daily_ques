// Last updated: 8/6/2025, 4:45:26 PM
class Solution {
    public int kthFactor(int n, int k) {
        int count =0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) { // Check if i is a factor
                count++;
                if (count == k) {
                    return i; // Return the kth factor
                }
            }
        }
        
        return -1; 
    }
}