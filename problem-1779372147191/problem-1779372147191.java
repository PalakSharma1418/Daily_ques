// Last updated: 5/21/2026, 7:32:27 PM
1class Solution {
2
3    class Node {
4        Node[] child;
5        boolean isEnd;
6
7        Node() {
8            child = new Node[10];
9            isEnd = false;
10        }
11    }
12
13    void insert(String word, Node root) {
14        Node temp = root;
15
16        for (char ch : word.toCharArray()) {
17            int idx = ch - '0';
18
19            if (temp.child[idx] == null) {
20                temp.child[idx] = new Node();
21            }
22
23            temp = temp.child[idx];
24        }
25
26        temp.isEnd = true;
27    }
28
29    int check(String str, Node root) {
30        Node temp = root;
31        int idx = 0;
32
33        while (idx < str.length()) {
34            int i = str.charAt(idx) - '0';
35
36            if (temp.child[i] != null) {
37                temp = temp.child[i];
38                idx++;
39            } else {
40                break;
41            }
42        }
43
44        return idx;
45    }
46
47    public int longestCommonPrefix(int[] arr1, int[] arr2) {
48        Node root = new Node();
49
50        for (int x : arr2) {
51            insert(String.valueOf(x), root);
52        }
53
54        int ans = 0;
55
56        for (int x : arr1) {
57            ans = Math.max(ans, check(String.valueOf(x), root));
58        }
59
60        return ans;
61    }
62}