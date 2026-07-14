// Last updated: 7/14/2026, 5:55:58 PM
1class Solution {
2    public List<Integer> lexicalOrder(int n) {
3        
4        List<Integer> ll= new ArrayList<>();
5        if(n==1){
6            ll.add(1);
7            return ll;
8        }
9        if(n==2){
10            ll.add(1);
11            ll.add(2);
12            return ll;
13        }
14        print(n,0,ll);
15        return ll;
16    }
17    public static void print(int  n,int curr,List<Integer> ll){
18        if(curr>n){
19            return;
20        }
21        if(curr !=0 ){
22            // System.out.println(curr);
23            ll.add(curr);
24        }
25        int i=0;
26        if(curr==0){
27            i=1;
28        }
29        for(;i<=9;i++){
30            print(n, curr*10+i,ll);
31        }
32    }
33}