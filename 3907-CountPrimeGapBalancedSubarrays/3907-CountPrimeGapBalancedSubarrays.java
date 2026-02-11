// Last updated: 2/11/2026, 7:20:41 AM
class Solution {
    public int primeSubarray(int[] nums, int k) {

        int n = nums.length;

        int right = 0;          // window right pointer
        int left = 0;           // window left pointer
        int totalSubarrays = 0;

        int primeCount = 0;

        int lastPrimeIndex = -1;
        int secondLastPrimeIndex = -1;

        Deque<Integer> minPrimeDeque = new ArrayDeque<>();
        Deque<Integer> maxPrimeDeque = new ArrayDeque<>();

        while (right < n) {

            int currentNumber = nums[right];

            // If current number is prime
            if (isPrime(currentNumber)) {

                primeCount++;

                secondLastPrimeIndex = lastPrimeIndex;
                lastPrimeIndex = right;

                // Maintain minimum prime deque
                while (!minPrimeDeque.isEmpty() &&
                       minPrimeDeque.peekLast() > currentNumber) {
                    minPrimeDeque.pollLast();
                }
                minPrimeDeque.addLast(currentNumber);

                // Maintain maximum prime deque
                while (!maxPrimeDeque.isEmpty() &&
                       maxPrimeDeque.peekLast() < currentNumber) {
                    maxPrimeDeque.pollLast();
                }
                maxPrimeDeque.addLast(currentNumber);
            }

            // Shrink window if maxPrime - minPrime > k
            while (!minPrimeDeque.isEmpty() &&
                   !maxPrimeDeque.isEmpty() &&
                   maxPrimeDeque.peekFirst() - minPrimeDeque.peekFirst() > k) {

                if (nums[left] == minPrimeDeque.peekFirst())
                    minPrimeDeque.pollFirst();

                if (nums[left] == maxPrimeDeque.peekFirst())
                    maxPrimeDeque.pollFirst();

                if (isPrime(nums[left]))
                    primeCount--;

                left++;
            }

            // Count valid subarrays
            if (primeCount >= 2) {
                totalSubarrays += Math.max(
                        0,
                        secondLastPrimeIndex - left + 1
                );
            }

            right++;
        }

        return totalSubarrays;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
