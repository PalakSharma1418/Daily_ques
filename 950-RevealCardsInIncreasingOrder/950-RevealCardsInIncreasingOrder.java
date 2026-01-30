// Last updated: 1/30/2026, 12:05:42 PM
1class Solution {
2    public int[] deckRevealedIncreasing(int[] deck) {
3        int n = deck.length;
4        Queue<Integer> q = new LinkedList<>();
5        for(int i=0 ; i< n ; i++){
6            q.add(i);
7        }
8        ArrayList<Integer> ll = new ArrayList<>();
9        int ans[] = new int[n];
10        Arrays.sort(deck);
11        int i=0;
12        while(!q.isEmpty()){
13            int s = q.poll();
14            ans[s]=deck[i++];
15            if(q.size()>1){
16                q.add(q.poll());
17            }
18        }
19        // for(int i =0 ; i< n ; i++){
20        //     int ind = ll.get(i);
21        //     ans[ind] = deck[i];
22        // }
23        return ans;
24    }
25}