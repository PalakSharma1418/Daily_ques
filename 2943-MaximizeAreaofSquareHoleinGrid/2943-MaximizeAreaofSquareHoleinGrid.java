// Last updated: 1/15/2026, 7:14:35 PM
1class Solution {
2    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
3        Arrays.sort(hBars);
4        Arrays.sort(vBars);
5        int h = 1;
6        int hso=0;
7        int pre = hBars[0];
8        for(int i=1 ; i<hBars.length ; i++){
9            if(hBars[i]-1==pre){
10                h++;
11            }else{
12                hso = Math.max(hso,h);
13                h=1;
14            }
15            pre=hBars[i];
16        }
17        hso = Math.max(hso,h)+1;
18        int v = 1 ;
19        int vso=0;
20        pre = vBars[0];
21        for(int i=1 ; i<vBars.length ; i++){
22            if(vBars[i]-1==pre){
23                v++;
24            }else{
25                vso = Math.max(vso,v);
26                v=1;
27            }
28            pre=vBars[i];
29        }
30        vso = Math.max(vso,v)+1;
31        int side = Math.min(hso,vso);
32        return side*side;
33    }
34}