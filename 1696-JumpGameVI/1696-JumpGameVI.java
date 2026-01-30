// Last updated: 1/30/2026, 12:30:44 PM
1class Solution {
2    public int maxResult(int[] nums, int k) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        dp[0] = nums[0];
6        Deque<Integer> deque = new ArrayDeque<>();
7        deque.addLast(0);
8
9        for (int i = 1; i < n; i++) {
10            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
11                deque.pollFirst();
12            }
13            dp[i] = nums[i] + dp[deque.peekFirst()];
14            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
15                deque.pollLast();
16            }
17            deque.addLast(i);
18        }
19
20        return dp[n - 1];
21    }
22}
23
24