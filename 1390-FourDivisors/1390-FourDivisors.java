// Last updated: 1/4/2026, 5:48:04 AM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int sum = 0;
4        for (int n : nums) {
5            sum += divisor(n);
6        }
7        return sum;
8    }
9
10    public int divisor(int n) {
11        int count = 0;
12        int sum = 0;
13
14        for (int i = 1; i * i <= n; i++) {
15            if (n % i == 0) {
16                int j = n / i;
17
18                if (i == j) {
19                    count += 1;
20                    sum += i;
21                } else {
22                    // 7*3=21 hoga but sqrt ki bjh se 7 nhu ayega to ese hi 
23                    count += 2;
24                    sum += i + j;
25                }
26
27                if (count > 4) return 0; 
28            }
29        }
30
31        return count == 4 ? sum : 0;
32    }
33}