// Last updated: 1/3/2026, 7:29:00 AM
1class Solution {
2    public int numOfWays(int n) {
3        long mod = 1000000007;
4        
5        long dpA = 6; // ABA
6        long dpB = 6; // ABC
7        
8        for(int i = 2; i <= n; i++){
9            long newA = (dpA * 3 + dpB * 2) % mod;
10            long newB = (dpA * 2 + dpB * 2) % mod;
11            
12            dpA = newA;
13            dpB = newB;
14        }
15        
16        return (int)((dpA + dpB) % mod);
17    }
18}