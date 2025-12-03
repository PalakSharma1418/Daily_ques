// Last updated: 12/3/2025, 3:14:51 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        Integer[][][] dp = new Integer[n][2][3];  // memo table
5        return fun(prices, 0, 1,2, dp);
6    }
7
8    public int fun(int[] arr, int ind, int buy,int k, Integer[][][] dp) {
9         if (k == 0) return 0;
10        if (ind == arr.length) return 0;
11
12        if (dp[ind][buy][k] != null) return dp[ind][buy][k];
13
14        int profit = 0;
15
16        if (buy == 1) {
17            // Option 1: Buy
18            int take = -arr[ind] + fun(arr, ind + 1, 0,k, dp);
19
20            // Option 2: Skip
21            int skip = fun(arr, ind + 1, 1,k, dp);
22
23            profit = Math.max(take, skip);
24
25        } else {
26            // Option 1: Sell
27            int sell = arr[ind] + fun(arr, ind + 1, 1,k-1, dp);
28
29            // Option 2: Skip
30            int skip = fun(arr, ind + 1, 0,k, dp);
31
32            profit = Math.max(sell, skip);
33        }
34
35        return dp[ind][buy][k] = profit;
36    }
37}
38
39