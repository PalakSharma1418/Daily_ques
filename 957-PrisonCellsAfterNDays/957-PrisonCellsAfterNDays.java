// Last updated: 12/20/2025, 3:29:52 PM
1class Solution {
2    public int[] prisonAfterNDays(int[] cells, int N) {
3        if(cells==null || cells.length==0 || N<=0) return cells; 
4        boolean hasCycle = false; 
5        int cycle = 0; 
6        HashSet<String> set = new HashSet<>();
7        for(int i=0;i<N;i++){
8            int[] next = nextDay(cells);
9            String key = Arrays.toString(next);
10            if(!set.contains(key)){ 
11                set.add(key);
12                cycle++;
13            }
14            else{
15                hasCycle = true;
16                break;
17            }
18            cells = next;
19        }
20
21        if(hasCycle){
22            N = N%cycle;
23            for(int i=0;i<N;i++){
24                cells = nextDay(cells);
25            }   
26        }
27         
28        return cells; 
29    }
30    
31    public int[] nextDay(int [] arr){
32        int[] tem = new int[8];
33        for(int i=1;i<arr.length-1;i++){
34            if(arr[i-1]==arr[i+1]){
35                tem[i]=1;
36            }
37        }
38        return tem;
39    } 
40}