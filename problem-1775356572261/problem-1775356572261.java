// Last updated: 4/5/2026, 8:06:12 AM
1class Solution {
2    public int mirrorFrequency(String s) {
3        HashMap<Character , Integer > freq = new HashMap<>();
4        for(char c : s.toCharArray()){
5            freq.put(c , freq.getOrDefault(c,0)+1);
6        }
7        HashSet<Character> vis = new HashSet<>();
8        int total =0 ;
9        for(char c : freq.keySet()){
10            if(vis.contains(c)) continue;
11            char m = mirror(c);
12            int a = freq.getOrDefault(c,0);
13            int b = freq.getOrDefault(m,0);
14            total = total + Math.abs(a - b);
15            vis.add(c);
16            vis.add(m);
17        }
18        return total;
19    }
20    public static char mirror(char ch){
21        if(ch>='a' && ch <= 'z'){
22            return (char)('z' - (ch - 'a'));
23        }
24        else{
25            return (char)('9' - ( ch - '0'));
26        }
27    }
28}