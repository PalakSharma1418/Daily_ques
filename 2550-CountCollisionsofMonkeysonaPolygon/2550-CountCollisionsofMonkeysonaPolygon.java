// Last updated: 1/22/2026, 7:42:15 PM
1class Solution {
2    public int monkeyMove(int n) {
3        long mod = 1_000_000_007;
4        long total = modPow(2, n, mod);
5        total = (total - 2 + mod) % mod; // avoid negative
6        return (int) total;
7    }
8    private long modPow(int n, long pow,long mod){
9        if(pow==0) return 1;
10        long ans=modPow(n,pow/2,mod);
11        ans=(ans*ans)%mod;
12        if(pow%2!=0) ans=(ans*n)%mod;
13        return ans%mod;
14    }
15}