// Last updated: 8/6/2025, 4:48:59 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n>0 && (n&(n-1))==0)
            return true;
        else
            return false;
    }
}
// n has only one 1 bit in binary.
// n - 1 flips that 1 to 0 and turns all lower bits to 1.
// Performing n & (n - 1) results in all 0s.