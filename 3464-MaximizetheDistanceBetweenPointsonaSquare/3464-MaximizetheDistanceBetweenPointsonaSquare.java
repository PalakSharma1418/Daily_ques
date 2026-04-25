// Last updated: 4/25/2026, 6:52:10 AM
1class Solution {
2    public int maxDistance(int s, int[][] p, int k) {
3        long[] x = new long[p.length];
4        for(int i=0; i<x.length; i++){
5            x[i]=getX(p[i], s);
6        }
7        Arrays.sort(x);
8
9        int l=1, r=s, m;
10        while(l<r){
11            m=(l+r+1)/2;
12            if(possible(4L*s, x, m, k))l=m;
13            else r=m-1;
14        }
15        return r;
16    }
17    private long getX(int[] p, int s){
18        if(p[1]==0)return p[0];
19        else if(p[1]==s)return 3L*s-p[0];
20        else if(p[0]==s)return p[1] + (long)s;
21        else return 4L*s - p[1];
22    }
23    private boolean possible(long r, long[] x, int m, int k){
24        int c;
25        for(int i=0; i<x.length&&x[i]-x[0]<m; i++){
26            c=i;
27            for(int j=1; j<k; j++){
28                c=get(x, x[c]+m, c);
29                if(c==x.length||x[c]+m-r>x[i])break;
30            }
31            if(c<x.length&&x[c]+m-r<=x[i])return true;
32        }
33        return false;
34    }
35    private int get(long[] x, long v, int f){
36        int t = x.length, m;
37        while(f<t){
38            m=(f+t)/2;
39            if(x[m]<v)f=m+1;
40            else t=m;
41        }
42        return f;
43    }
44}