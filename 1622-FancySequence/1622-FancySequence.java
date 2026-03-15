// Last updated: 3/15/2026, 7:24:45 PM
1class Fancy {
2
3    static final long MOD = 1000000007;
4    List<Long> arr;
5    long mul, add;
6
7    public Fancy() {
8        arr = new ArrayList<>();
9        mul = 1;
10        add = 0;
11    }
12
13    long modPow(long a, long b) {
14        long res = 1;
15        a %= MOD;
16
17        while (b > 0) {
18            if ((b & 1) == 1)
19                res = (res * a) % MOD;
20
21            a = (a * a) % MOD;
22            b >>= 1;
23        }
24
25        return res;
26    }
27
28    long modInverse(long x) {
29        return modPow(x, MOD - 2);
30    }
31
32    public void append(int val) {
33        long stored = ((val - add + MOD) % MOD * modInverse(mul)) % MOD;
34        arr.add(stored);
35    }
36
37    public void addAll(int inc) {
38        add = (add + inc) % MOD;
39    }
40
41    public void multAll(int m) {
42        mul = (mul * m) % MOD;
43        add = (add * m) % MOD;
44    }
45
46    public int getIndex(int idx) {
47        if (idx >= arr.size()) return -1;
48        return (int)((arr.get(idx) * mul + add) % MOD);
49    }
50}