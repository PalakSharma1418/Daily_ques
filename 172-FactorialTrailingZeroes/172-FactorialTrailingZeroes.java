// Last updated: 8/6/2025, 4:49:23 PM
class Solution {
    public int trailingZeroes(int n) {
      int count = 0;
        int powerOf5 = 5;
        while (n >= powerOf5) {
            count += n / powerOf5;
            powerOf5 *= 5;// 150/5 150/25 150/125 ==30+6+1
        }
        return count;
        }

}