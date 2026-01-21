// Last updated: 1/21/2026, 7:47:26 PM
1class Solution {
2    public int primeSubarray(int[] nums, int k) {
3        int n = nums.length;
4        int st = 0;
5        int end = 0;
6        int ans = 0;
7        int prime = 0;
8
9        int lastPrimePos = -1;
10        int secondLastPrimePos = -1;
11
12        Deque<Integer> min = new ArrayDeque<>();
13        Deque<Integer> max = new ArrayDeque<>();
14
15        while (st < n) {
16            int num = nums[st];
17
18            if (isPrime(num)) {
19                prime++;
20                secondLastPrimePos = lastPrimePos;
21                lastPrimePos = st;
22
23                while (!min.isEmpty() && min.peekLast() > num)
24                    min.pollLast();
25                min.addLast(num);
26
27                while (!max.isEmpty() && max.peekLast() < num)
28                    max.pollLast();
29                max.addLast(num);
30            }
31
32            while (!min.isEmpty() && !max.isEmpty()
33                    && max.peekFirst() - min.peekFirst() > k) {
34
35                if (nums[end] == min.peekFirst()) min.pollFirst();
36                if (nums[end] == max.peekFirst()) max.pollFirst();
37                if (isPrime(nums[end])) prime--;
38                end++;
39            }
40
41            if (prime >= 2) {
42                ans += Math.max(0, secondLastPrimePos - end + 1);
43            }
44
45            st++;
46        }
47        return ans;
48    }
49
50    public boolean isPrime(int el) {
51        if (el <= 1) return false;
52        for (int i = 2; i * i <= el; i++) {
53            if (el % i == 0) return false;
54        }
55        return true;
56    }
57}