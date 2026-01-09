// Last updated: 1/9/2026, 10:57:36 AM
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += divisor(n);
        }
        return sum;
    }

    public int divisor(int n) {
        int count = 0;
        int sum = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;

                if (i == j) {
                    count += 1;
                    sum += i;
                } else {
                    // 7*3=21 hoga but sqrt ki bjh se 7 nhu ayega to ese hi 
                    count += 2;
                    sum += i + j;
                }

                if (count > 4) return 0; 
            }
        }

        return count == 4 ? sum : 0;
    }
}