// Last updated: 5/20/2026, 7:36:33 PM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length;
4
5        int[] freq = new int[n + 1];
6        int[] ans = new int[n];
7
8        int cnt = 0;
9
10        for(int i = 0; i < n; i++) {
11
12            freq[A[i]]++;
13            if(freq[A[i]] == 2) cnt++;
14
15            freq[B[i]]++;
16            if(freq[B[i]] == 2) cnt++;
17
18            ans[i] = cnt;
19        }
20
21        return ans;
22    }
23}