// Last updated: 1/6/2026, 1:01:42 PM
1class Solution {
2    public int snakesAndLadders(int[][] board) {
3        int n=board.length;
4        Queue<pair> q=new LinkedList<>();
5        boolean[] visit=new boolean[n*n+1];
6        visit[1]=true;
7        q.add(new pair(1,0));
8        while(!q.isEmpty()){
9            pair r=q.poll();
10            int cell=r.cell;
11            int moves=r.moves;
12            for(int i=1;i<=6;i++){
13                int next=cell+i;
14                if(next>n*n){
15                    continue;
16                }
17                int nextcell=newcell(board,n,next);
18                if(nextcell==n*n){
19                    return moves+1;
20                }
21                if(!visit[nextcell]){
22                    visit[nextcell]=true;
23                    q.add(new pair(nextcell,moves+1));
24                }
25            }
26        }
27        return -1;
28    }
29    public int newcell(int[][] ar,int n,int next){
30        int row=(next-1)/n;
31        int col=(next-1)%n;
32        if(row%2!=0){
33            col=n-1-col;
34        }
35        int val=ar[n-1-row][col];
36        return val==-1?next:val;
37    }
38}
39class pair{
40    int cell;
41    int moves;
42    public pair(int cell,int moves){
43        this.cell=cell;
44        this.moves=moves;
45    }
46}