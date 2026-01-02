// Last updated: 1/2/2026, 8:30:41 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    
23    HashMap<Node, Node> map = new HashMap<>();
24
25    void dfs(Node node, Node cloneNode) {
26        for (Node nei : node.neighbors) {
27            if (!map.containsKey(nei)) {
28                Node clone = new Node(nei.val);
29                map.put(nei, clone);
30                cloneNode.neighbors.add(clone);
31                dfs(nei, clone);
32            } else {
33                cloneNode.neighbors.add(map.get(nei));
34            }
35        }
36    }
37
38    public Node cloneGraph(Node node) {
39        if (node == null) return null;
40
41        Node cloneNode = new Node(node.val);
42        map.put(node, cloneNode);
43
44        dfs(node, cloneNode);
45        return cloneNode;
46    }
47}
48