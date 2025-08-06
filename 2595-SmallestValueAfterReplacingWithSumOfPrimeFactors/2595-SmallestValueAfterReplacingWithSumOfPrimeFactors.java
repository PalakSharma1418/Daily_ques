// Last updated: 8/6/2025, 4:42:47 PM
class Solution {
    public int smallestValue(int n) {
        // Keep replacing n with the sum of its prime factors
        while (true) {
            int sum = sumOfPrimeFactors(n);
            if (sum == n) {
                break; // n cannot be reduced further
            }
            n = sum;
        }
        return n;
    }
    public  int sumOfPrimeFactors(int num) {
            int sum = 0;
            while (num % 2 == 0) {
                sum += 2;
                num /= 2;
            }
            for (int i = 3; i * i <= num; i += 2) {
                while (num % i == 0) {
                    sum += i;
                    num /= i;
                }
            }
            if (num > 1) {
                sum += num;
            }
            return sum;
        }

}
