// Last updated: 12/3/2025, 3:06:52 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        Integer[][] dp = new Integer[n][2];  // memo table
5        return fun(prices, 0, 1, dp);
6    }
7
8    public int fun(int[] arr, int ind, int buy, Integer[][] dp) {
9        if (ind == arr.length) return 0;
10
11        if (dp[ind][buy] != null) return dp[ind][buy];
12
13        int profit = 0;
14
15        if (buy == 1) {
16            // Option 1: Buy
17            int take = -arr[ind] + fun(arr, ind + 1, 0, dp);
18
19            // Option 2: Skip
20            int skip = fun(arr, ind + 1, 1, dp);
21
22            profit = Math.max(take, skip);
23
24        } else {
25            // Option 1: Sell
26            int sell = arr[ind] + fun(arr, ind + 1, 1, dp);
27
28            // Option 2: Skip
29            int skip = fun(arr, ind + 1, 0, dp);
30
31            profit = Math.max(sell, skip);
32        }
33
34        return dp[ind][buy] = profit;
35    }
36}
37