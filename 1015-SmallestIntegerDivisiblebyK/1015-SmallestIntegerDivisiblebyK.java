// Last updated: 11/25/2025, 4:48:02 PM
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