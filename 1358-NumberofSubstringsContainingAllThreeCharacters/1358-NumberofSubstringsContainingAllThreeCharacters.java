// Last updated: 6/30/2026, 8:15:29 PM
1class Solution {
2    public int numberOfSubstrings(String s) {
3        HashMap<Character, Integer> map = new HashMap<>();
4        int left = 0;
5        int count = 0;
6        int n = s.length();
7
8        for (int right = 0; right < n; right++) {
9            char ch = s.charAt(right);
10            map.put(ch, map.getOrDefault(ch, 0) + 1);
11            while (abc(map)) {
12                count += (n - right);
13                char c = s.charAt(left);
14                map.put(c, map.get(c) - 1);
15                left++;
16            }
17        }
18        return count;
19    }
20
21    public boolean abc(HashMap<Character, Integer> map) {  // Fixed type
22        return map.getOrDefault('a', 0) > 0 && 
23               map.getOrDefault('b', 0) > 0 && 
24               map.getOrDefault('c', 0) > 0;  // Fixed condition
25    }
26}
27