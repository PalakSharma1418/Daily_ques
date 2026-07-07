// Last updated: 7/7/2026, 10:25:50 AM
1class Solution {
2    public long sumAndMultiply(int n) {
3        long x = 0; //4
4        long sum = 0;
5        long place = 1; //10
6
7        while (n > 0) {
8            int rem = n % 10;
9
10            if (rem != 0) {
11                x = rem * place + x; 
12                place *= 10;
13                sum += rem;
14            }
15
16            n /= 10;
17        }
18
19        return x * sum;
20    }
21}