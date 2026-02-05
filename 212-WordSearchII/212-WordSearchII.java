// Last updated: 2/5/2026, 12:42:11 PM
1class Solution {
2
3    static class Trie {
4        class Node {
5            char ch;
6            String isTerminal;
7            HashMap<Character, Node> child;
8
9            public Node(char ch) {
10                this.ch = ch;
11                child = new HashMap<>();
12            }
13        }
14
15        Node root = new Node('*');
16
17        public void insert(String word) {
18            Node curr = root;
19            for (int i = 0; i < word.length(); i++) {
20                char ch = word.charAt(i);
21                if (!curr.child.containsKey(ch)) {
22                    curr.child.put(ch, new Node(ch));
23                }
24                curr = curr.child.get(ch);
25            }
26            curr.isTerminal = word;
27        }
28
29        private void dfs(char[][] board, int r, int c, Node node) {
30
31            if (r < 0 || c < 0 || r >= board.length ||
32                c >= board[0].length || !node.child.containsKey(board[r][c])) {
33                return;
34            }
35
36            char ch = board[r][c];
37            Trie.Node curr = node.child.get(ch);
38
39            // word found
40            if (curr.isTerminal != null) {
41                ans.add(curr.isTerminal);
42                curr.isTerminal = null; // avoid duplicates
43            }
44
45            board[r][c] = '*'; // mark visited
46
47            dfs(board, r + 1, c, curr);
48            dfs(board, r - 1, c, curr);
49            dfs(board, r, c + 1, curr);
50            dfs(board, r, c - 1, curr);
51
52            board[r][c] = ch; // restore
53        }
54    }
55
56    static List<String> ans = new ArrayList<>();
57
58    public List<String> findWords(char[][] board, String[] words) {
59        ans.clear(); 
60        Trie t = new Trie();
61
62        // build trie
63        for (String s : words) {
64            t.insert(s);
65        }
66
67        // start DFS from each cell
68        for (int i = 0; i < board.length; i++) {
69            for (int j = 0; j < board[0].length; j++) {
70                if (t.root.child.containsKey(board[i][j])) {
71                    t.dfs(board, i, j, t.root);
72                }
73            }
74        }
75        return ans;
76    }
77
78    
79}
80