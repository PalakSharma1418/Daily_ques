// Last updated: 1/4/2026, 11:15:16 AM
1class Solution {
2    static class Pair{
3        String s;
4        int step;
5        public Pair(String s , int step){
6            this.s=s;
7            this.step=step;
8        }
9    }
10    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
11        Set<String> set = new HashSet<>(wordList);
12        if(!set.contains(endWord)) return 0;
13        Queue<Pair> q = new LinkedList<>();
14        q.add(new Pair(beginWord,1));
15
16        if(set.contains(beginWord)){
17            set.remove(beginWord);
18        }
19
20        while(!q.isEmpty()){
21            Pair rm = q.poll();
22            if(rm.s.equals(endWord)){
23                return rm.step;
24            }
25
26            char str[]= (rm.s).toCharArray();
27            for(int in=0;in<str.length;in++){
28                char ch = str[in];
29                for(char i='a';i<='z';i++){
30                    if(ch==i) continue;
31                    str[in]=i;
32                    String nayi = new String(str);
33                    if(set.contains(nayi)){
34                        q.add(new Pair(nayi,rm.step+1));
35                        set.remove(nayi);
36                    }
37                    str[in]=ch;
38                }
39            }
40        }
41        return 0;
42    }
43}