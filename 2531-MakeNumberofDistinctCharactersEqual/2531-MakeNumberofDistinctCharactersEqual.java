// Last updated: 1/23/2026, 1:50:25 PM
1class Solution {
2    public boolean isItPossible(String word1, String word2) {
3        Map<Character, Integer> freq1 = new HashMap<>();
4        Map<Character, Integer> freq2 = new HashMap<>();
5
6        for (char ch : word1.toCharArray()) freq1.put(ch, freq1.getOrDefault(ch, 0) + 1);
7        for (char ch : word2.toCharArray()) freq2.put(ch, freq2.getOrDefault(ch, 0) + 1);
8
9        int sz1 = freq1.size(), sz2 = freq2.size();
10
11        for (char c1 = 'a'; c1 <= 'z'; ++c1) {
12            for (char c2 = 'a'; c2 <= 'z'; ++c2) {
13                if (freq1.getOrDefault(c1, 0) > 0 && freq2.getOrDefault(c2, 0) > 0) {
14                    if (c1 == c2) {
15                        if (sz1 == sz2) return true;
16                    } else {
17                        int cnt1 = sz1, cnt2 = sz2;
18
19                        if (freq1.getOrDefault(c1, 0) == 1) cnt1--;
20                        if (freq1.getOrDefault(c2, 0) == 0) cnt1++;
21
22                        if (freq2.getOrDefault(c1, 0) == 0) cnt2++;
23                        if (freq2.getOrDefault(c2, 0) == 1) cnt2--;
24
25                        if (cnt1 == cnt2) return true;
26                    }
27                }
28            }
29        }
30
31        return false;
32    }
33}
34