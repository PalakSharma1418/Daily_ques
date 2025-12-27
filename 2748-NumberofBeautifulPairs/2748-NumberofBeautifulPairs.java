// Last updated: 12/27/2025, 4:19:47 PM
1class Solution {
2    public int countBeautifulPairs(int[] nums) {
3        int pairs = 0;
4        for (int i = 0; i < nums.length; ++i) {
5            int d = nums[i] % 10;
6            for (int j = 0; j < i; ++j) {
7                int n = nums[j];
8                while (n >= 10) {
9                    n /= 10;
10                }
11                pairs += gcd(n, d) == 1 ? 1 : 0;
12            }
13        }
14        return pairs;
15    }
16     private int gcd(int x, int y) {
17        while (y != 0) {
18            int tmp = x % y;
19            x = y;
20            y = tmp;
21        }
22        return x;
23    }
24}