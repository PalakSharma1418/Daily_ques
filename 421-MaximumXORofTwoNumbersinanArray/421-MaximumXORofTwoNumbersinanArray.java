// Last updated: 2/11/2026, 12:45:41 PM
1class Solution {
2    static class Trie{
3        class Node{
4            Node zero;
5            Node one;
6        }
7        private Node root = new Node();
8
9        public void add(int val){
10            Node curr = root;
11            for(int i = 31; i >= 0; i--){
12                int bit = val & (1 << i);
13
14                if(bit == 0){
15                    if(curr.zero == null){
16                        curr.zero = new Node();
17                    }
18                    curr = curr.zero;
19                }
20                else{
21                    if(curr.one == null){
22                        curr.one = new Node();
23                    }
24                    curr = curr.one;
25                }
26            }
27        }
28
29        public int getMaxXor(int x){
30            int ans = 0;
31            Node curr = root;
32
33            for(int i = 31; i >= 0; i--){
34                int bit = x & (1 << i);
35
36                if(bit == 0){
37                    if(curr.one != null){
38                        ans |= (1 << i);
39                        curr = curr.one;
40                    }
41                    else{
42                        curr = curr.zero;
43                    }
44                }
45                else{
46                    if(curr.zero != null){
47                        ans |= (1 << i);
48                        curr = curr.zero;
49                    }
50                    else{
51                        curr = curr.one;
52                    }
53                }
54            }
55            return ans;
56        }
57    }
58
59    public int findMaximumXOR(int[] nums) {
60        Trie t = new Trie();
61
62        for(int x : nums){
63            t.add(x);
64        }
65
66        int ans = 0;
67
68        for(int x : nums){
69            ans = Math.max(ans, t.getMaxXor(x));
70        }
71
72        return ans;
73    }
74}
75