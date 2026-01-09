// Last updated: 1/9/2026, 10:56:30 AM
class Solution {
    public int minimumOneBitOperations(int n) {
        int result = 0;
        while (n > 0) {
            result ^= n;
            n = n >> 1;
        }    
        return result;
    }
}