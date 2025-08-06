// Last updated: 8/6/2025, 4:42:43 PM
class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(i>2 &&  i%2==0 ){
                continue;
            }
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int num1 = primes.get(i);
            int num2 = primes.get(i + 1);
            int diff = num2 - num1;
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = num1;
                result[1] = num2;
            }
        }

        return result;
    }
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
