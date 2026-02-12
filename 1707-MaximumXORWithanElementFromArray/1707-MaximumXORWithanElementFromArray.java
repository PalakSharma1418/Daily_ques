// Last updated: 2/12/2026, 12:10:04 PM
1class Solution {
2    public int[] maximizeXor(int[] arr, int[][] queries) {
3        int[][] q= new int[queries.length][3];
4        for(int i=0;i<q.length;i++){
5            q[i][0]=queries[i][0];//xi
6            q[i][1]=queries[i][1];//mi
7            q[i][2]=i;//index
8        }
9        Arrays.sort(arr);
10        Arrays.sort(q,(a,b) -> a[1]-b[1]);
11        Trie t = new Trie();
12        int[]ans = new int[q.length];
13        int j=0;
14        for(int []a : q){
15            while(j<arr.length && arr[j]<=a[1]){
16                t.add(arr[j]);
17                j++;
18            }
19            if(j==0){
20                ans[a[2]]=-1;
21            }
22            else{
23                ans[a[2]]=t.getMaxXor(a[0]);
24            }
25        }
26        return ans;
27    }
28    static class Trie{
29        class Node{
30            Node zero;
31            Node one;
32        }
33        private Node root = new Node();
34
35        public void add(int val){
36            Node curr = root;
37            for(int i = 31; i >= 0; i--){
38                int bit = val & (1 << i);
39
40                if(bit == 0){
41                    if(curr.zero == null){
42                        curr.zero = new Node();
43                    }
44                    curr = curr.zero;
45                }
46                else{
47                    if(curr.one == null){
48                        curr.one = new Node();
49                    }
50                    curr = curr.one;
51                }
52            }
53        }
54
55        public int getMaxXor(int x){
56            int ans = 0;
57            Node curr = root;
58
59            for(int i = 31; i >= 0; i--){
60                int bit = x & (1 << i);
61
62                if(bit == 0){
63                    if(curr.one != null){
64                        ans |= (1 << i);
65                        curr = curr.one;
66                    }
67                    else{
68                        curr = curr.zero;
69                    }
70                }
71                else{
72                    if(curr.zero != null){
73                        ans |= (1 << i);
74                        curr = curr.zero;
75                    }
76                    else{
77                        curr = curr.one;
78                    }
79                }
80            }
81            return ans;
82        }
83    }
84}