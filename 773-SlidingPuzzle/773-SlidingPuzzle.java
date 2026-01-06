// Last updated: 1/6/2026, 12:21:40 PM
1class Solution {
2    public int slidingPuzzle(int[][] board) {
3        int[][] directions=new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
4        String begin="";
5        for(int i=0;i<2;i++){
6            for(int j=0;j<3;j++){
7                begin+=board[i][j];
8            }
9        }
10        String end="123450";
11        HashSet<String> set=new HashSet<>();
12        Queue<pair> q=new LinkedList<>();
13        set.add(begin);
14        q.add(new pair(begin,0));
15        while(!q.isEmpty()){
16            pair rp=q.poll();
17            if(rp.s.equals(end)){
18                return rp.moves;
19            }
20            char[] car=rp.s.toCharArray();
21            int in=rp.s.indexOf('0');
22            for(int i:directions[in]){
23                swap(car,in,i);
24                String change=new String(car);
25                if(!set.contains(change)){
26                    q.add(new pair(change,rp.moves+1));
27                    set.add(change);
28                }
29                swap(car,i,in);
30            }
31        }
32        return -1;
33        
34    }
35    public void swap(char[] ar,int i,int j){
36        char t=ar[i];
37        ar[i]=ar[j];
38        ar[j]=t;
39    }
40}
41class pair{
42    String s;
43    int moves;
44    public pair(String s,int moves){
45        this.s=s;
46        this.moves=moves;
47    }
48}