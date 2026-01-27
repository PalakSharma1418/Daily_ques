// Last updated: 1/27/2026, 3:26:10 PM
1class Solution {
2    public int timeRequiredToBuy(int[] tickets, int k) {
3        int ans =0 ; 
4        Queue<Integer> q = new LinkedList<>();
5        for(int i=0 ; i<tickets.length ; i++){
6            q.add(i);
7        }
8        while(true){
9            int rm = q.poll();
10            if(tickets[rm]>0){
11                tickets[rm]--;
12                ans++;
13                if(tickets[rm]!=0){
14                    q.add(rm);
15                }
16                if(tickets[rm]==0 && rm==k){
17                    return ans;
18                }
19            }
20        }
21
22        //return ans;
23    }
24}