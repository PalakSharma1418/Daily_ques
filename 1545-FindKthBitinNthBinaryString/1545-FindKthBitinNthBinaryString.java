// Last updated: 3/3/2026, 6:11:35 PM
1class Solution {
2    public char findKthBit(int n, int k) {
3        if (n == 1) return '0';
4        
5        int len = (1 << n) - 1;
6        int mid = (len + 1) / 2;
7        
8        if (k == mid) return '1';
9        if (k < mid) return findKthBit(n - 1, k);
10        
11        char c = findKthBit(n - 1, len - k + 1);
12        return c == '0' ? '1' : '0';
13    }
14}