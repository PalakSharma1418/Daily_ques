// Last updated: 1/4/2026, 12:46:34 PM
1class Solution {
2    public int openLock(String[] deadends, String target) {
3        HashSet<String> set=new HashSet<>();
4        for(String s:deadends){
5            set.add(s);
6        }
7        if(set.contains("0000")){
8            return -1;
9        }
10        set.add("0000");
11        Queue<pair> q=new LinkedList<>();
12        
13        q.add(new pair("0000",0));
14        while(!q.isEmpty()){
15            pair r=q.poll();
16            if(r.l.equals(target)){
17                return r.turns;
18            }
19            char[] st=r.l.toCharArray();
20            for(int i=0;i<st.length;i++){
21                char ch=st[i];
22                for(int in=0;in<2;in++){
23                    if(in==0){
24                        if(ch=='0'){
25                            st[i]='9';
26                        }else{
27                            st[i]=(char)(st[i]-1);
28                        }
29                        
30                    }else{
31                        if(ch=='9'){
32                            st[i]='0';
33                        }else{
34                            st[i]=(char)(st[i]+1);
35                        }
36                    }
37                    String change=new String(st);
38                    if(!set.contains(change)){
39                        set.add(change);
40                        q.add(new pair(change,r.turns+1));
41                    }
42                    
43                    
44                     st[i]=ch;
45                }
46               
47            }
48        }
49
50        return -1;
51    }
52}
53class pair{
54    String l;
55    int turns;
56    public pair(String l,int turns){
57        this.l=l;
58        this.turns=turns;
59    }
60}