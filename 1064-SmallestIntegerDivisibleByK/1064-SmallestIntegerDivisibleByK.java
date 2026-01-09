// Last updated: 1/9/2026, 10:58:01 AM
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0) return -1;
        int remainder = 0;
        for (int length = 1; length <= k; length++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) return length;
        }
        return -1;
    }
}