// Last updated: 3/31/2026, 7:11:54 PM
1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length();
4        int m = str2.length();
5        int N = n + m - 1;
6
7        char[] word = new char[N];
8        boolean[] canChange = new boolean[N];
9
10        for (int i = 0; i < N; i++) {
11            word[i] = '$';
12        }
13        for (int i = 0; i < n; i++) {
14            if (str1.charAt(i) == 'T') {
15                int idx = i;
16                for (int j = 0; j < m; j++) {
17                    if (word[idx] != '$' && word[idx] != str2.charAt(j)) {
18                        return "";
19                    }
20                    word[idx] = str2.charAt(j);
21                    idx++;
22                }
23            }
24        }
25
26        for (int i = 0; i < N; i++) {
27            if (word[i] == '$') {
28                word[i] = 'a';
29                canChange[i] = true;
30            }
31        }
32
33        for (int i = 0; i < n; i++) {
34            if (str1.charAt(i) == 'F') {
35
36                if (isSame(word, str2, i, m)) {
37                    boolean changed = false;
38
39                    for (int k = i + m - 1; k >= i; k--) {
40                        if (canChange[k]) {
41                            word[k] = 'b';  // minimal change
42                            canChange[k] = false;
43                            changed = true;
44                            break;
45                        }
46                    }
47
48                    if (!changed) return "";
49                }
50            }
51        }
52
53        return new String(word);
54    }
55
56    private boolean isSame(char[] word, String str2, int i, int m) {
57        for (int j = 0; j < m; j++) {
58            if (word[i] != str2.charAt(j)) return false;
59            i++;
60        }
61        return true;
62    }
63}