// Last updated: 8/6/2025, 4:48:25 PM
class Solution {
    public int getSum(int a, int b) {
        int c; 
        while(b != 0) {
            c = (a & b);       // 1. Find carry (common bits of a and b)
            a = a ^ b;         // 2. Add without carrying
            b = c << 1;        // 3. Shift carry left (because it affects the next higher bit)
        }
        return a;
    }
}
