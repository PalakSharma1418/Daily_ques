// Last updated: 12/22/2025, 4:31:37 PM
1class Solution {
2    
3        
4     // lexicographic constructive counting
5        // Total permutations =
6//          (total characters)! / (c1! * c2! * ...)
7
8    
9
10    private static final long LIMIT = 1_000_000_000L;
11
12    public String smallestPalindrome(String s, int k) {
13        int[] freq = new int[26];
14        for (char c : s.toCharArray()) {
15            freq[c - 'a']++;
16        }
17        char middle = 0;
18        int halfLen = 0;
19        for (int i = 0; i < 26; i++) {
20            if (freq[i] % 2 == 1) {
21                middle = (char) (i + 'a');
22            }
23            freq[i] /= 2;
24            halfLen += freq[i];
25        }
26
27        long total = countPermutations(freq, halfLen);
28        if (total < k) return "";
29
30        StringBuilder firstHalf = new StringBuilder();
31        for (int pos = 0; pos < halfLen; pos++) {
32            for (int c = 0; c < 26; c++) {
33                if (freq[c] == 0) continue;
34                freq[c]--;
35                long cnt = countPermutations(freq, halfLen - pos - 1);
36                if (cnt < k) {//All permutations starting with this character come before our answer
37                    k -= cnt;
38                    freq[c]++;
39                } 
40                else {
41                    firstHalf.append((char) (c + 'a'));
42                    break;
43                }
44            }
45        }
46        StringBuilder secondHalf = new StringBuilder(firstHalf).reverse();
47        return middle == 0
48                ? firstHalf + secondHalf.toString()
49                : firstHalf + String.valueOf(middle) + secondHalf;
50    }
51    private long countPermutations(int[] freq, int total) {
52    long res = 1;
53    int used = 0;
54
55    for (int f : freq) {
56        for (int i = 1; i <= f; i++) {
57            res = res * (used + i) / i;
58            if (res > LIMIT) return LIMIT;
59        }
60        used += f;
61    }
62    return res;
63}
64
65
66    // private long countPermutations(int[] freq, int total) {
67    //     long result = factorial(total);
68    //     for (int f : freq) {
69    //         result /= factorial(f);
70    //     }
71    //     return Math.min(result, LIMIT);
72    // }
73
74    // private long factorial(int n) {
75    //     long res = 1;
76    //     for (int i = 1; i <= n; i++) {
77    //         res = Math.min(res * i, LIMIT);
78    //     }
79    //     return res;
80    // }
81}
82
83