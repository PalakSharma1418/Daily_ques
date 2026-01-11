// Last updated: 1/11/2026, 1:33:38 PM
1class Solution {
2    public int closestMeetingNode(int[] edges, int node1, int node2) {
3        int[] mind1=mindis(edges,node1);
4        int[] mind2=mindis(edges,node2);
5        int node=-1;
6        int ans=Integer.MAX_VALUE;
7        for(int i=0;i<mind1.length;i++){
8            if(mind1[i]==-1||mind2[i]==-1){
9                continue;
10            }
11            int mn=Math.max(mind1[i],mind2[i]);
12            if(mn<ans){
13                ans=mn;
14                node=i;
15            }
16        }
17        return node;
18        
19    }
20    public int[] mindis(int[] edges,int nd){
21        int[] mind=new int[edges.length];
22        Arrays.fill(mind,-1);
23        int d=0;
24        int cur=nd;
25        while(cur!=-1&&mind[cur]==-1){
26            mind[cur]=d;
27            cur=edges[cur];
28            d++;
29        }
30        return mind;
31    }
32}