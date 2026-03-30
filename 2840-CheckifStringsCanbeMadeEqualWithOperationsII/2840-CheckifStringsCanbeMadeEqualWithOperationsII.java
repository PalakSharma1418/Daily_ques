// Last updated: 3/30/2026, 2:35:51 PM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int n = s1.length();
4        int[] s1EvenFreq = new int[26];
5        int[] s2EvenFreq = new int[26];
6        for (int i = 0; i < n; i += 2) {
7            s1EvenFreq[s1.charAt(i) - 'a']++;
8            s2EvenFreq[s2.charAt(i) - 'a']++;
9        }
10
11        for (int i = 0; i < 26; i++) {
12            if (s1EvenFreq[i] != s2EvenFreq[i]) return false;
13        }
14
15        int[] s1OddFreq = new int[26];
16        int[] s2OddFreq = new int[26];
17        for (int i = 1; i < n; i += 2) {
18            s1OddFreq[s1.charAt(i) - 'a']++;
19            s2OddFreq[s2.charAt(i) - 'a']++;
20        }
21        for (int i = 0; i < 26; i++) {
22            if (s1OddFreq[i] != s2OddFreq[i]) return false;
23        }
24
25        return true;
26    }
27}