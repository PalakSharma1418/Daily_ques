// Last updated: 6/22/2026, 8:42:09 AM
1class Solution {
2    public int maxNumberOfBalloons(String text){
3        int b=0;
4        int a=0;
5        int l=0;
6        int o=0;
7        int n=0;
8
9        for (char c : text.toCharArray()) {
10            switch (c) {
11                case 'b': b++; break;
12                case 'a': a++; break;
13                case 'l': l++; break;
14                case 'o': o++; break;
15                case 'n': n++; break;
16            }
17        }
18        return Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
19    }
20}