// Last updated: 1/26/2026, 4:52:51 PM
1class Solution {
2    public int primeSubarray(int[] nums, int k) {
3
4        int n = nums.length;
5
6        int right = 0;          // window right pointer
7        int left = 0;           // window left pointer
8        int totalSubarrays = 0;
9
10        int primeCount = 0;
11
12        int lastPrimeIndex = -1;
13        int secondLastPrimeIndex = -1;
14
15        Deque<Integer> minPrimeDeque = new ArrayDeque<>();
16        Deque<Integer> maxPrimeDeque = new ArrayDeque<>();
17
18        while (right < n) {
19
20            int currentNumber = nums[right];
21
22            // If current number is prime
23            if (isPrime(currentNumber)) {
24
25                primeCount++;
26
27                secondLastPrimeIndex = lastPrimeIndex;
28                lastPrimeIndex = right;
29
30                // Maintain minimum prime deque
31                while (!minPrimeDeque.isEmpty() &&
32                       minPrimeDeque.peekLast() > currentNumber) {
33                    minPrimeDeque.pollLast();
34                }
35                minPrimeDeque.addLast(currentNumber);
36
37                // Maintain maximum prime deque
38                while (!maxPrimeDeque.isEmpty() &&
39                       maxPrimeDeque.peekLast() < currentNumber) {
40                    maxPrimeDeque.pollLast();
41                }
42                maxPrimeDeque.addLast(currentNumber);
43            }
44
45            // Shrink window if maxPrime - minPrime > k
46            while (!minPrimeDeque.isEmpty() &&
47                   !maxPrimeDeque.isEmpty() &&
48                   maxPrimeDeque.peekFirst() - minPrimeDeque.peekFirst() > k) {
49
50                if (nums[left] == minPrimeDeque.peekFirst())
51                    minPrimeDeque.pollFirst();
52
53                if (nums[left] == maxPrimeDeque.peekFirst())
54                    maxPrimeDeque.pollFirst();
55
56                if (isPrime(nums[left]))
57                    primeCount--;
58
59                left++;
60            }
61
62            // Count valid subarrays
63            if (primeCount >= 2) {
64                totalSubarrays += Math.max(
65                        0,
66                        secondLastPrimeIndex - left + 1
67                );
68            }
69
70            right++;
71        }
72
73        return totalSubarrays;
74    }
75
76    private boolean isPrime(int number) {
77        if (number <= 1) return false;
78        for (int i = 2; i * i <= number; i++) {
79            if (number % i == 0) return false;
80        }
81        return true;
82    }
83}
84