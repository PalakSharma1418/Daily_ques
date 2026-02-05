// Last updated: 2/5/2026, 12:17:45 PM
1class Solution {
2    static class Trie{
3        class Node {
4            char ch ;
5            String isTerminal;
6            HashMap<Character,Node> child ; 
7            public Node(char ch ){
8                this.ch = ch ; 
9                child= new HashMap<>();
10            }
11        }
12        private Node root = new Node('*');
13
14        public void insert(String word) {
15            Node curr = root;
16            for(int i=0  ; i<word.length() ; i++){
17                char ch = word.charAt(i);
18                if(curr.child.containsKey(ch)){
19                    curr=curr.child.get(ch);
20                }else{
21                    Node nn = new Node(ch);
22                    curr.child. put(ch,nn);
23                    curr= nn ; 
24                }
25            }
26            curr.isTerminal = word;
27        }
28
29        public String search(String word){
30            Node curr = root ; 
31            for(int i=0; i<word.length () ; i++){
32                char ch = word.charAt(i);
33                if(curr.child.containsKey(ch)){
34                    curr = curr.child.get(ch);
35                    if(curr.isTerminal != null){
36                        return curr.isTerminal;
37                    }
38                    
39                }
40                else{
41                        return word;
42                    }
43            }
44            return word ; 
45        }
46    }
47    public String replaceWords(List<String> dictionary, String sentence) {
48        Trie t = new Trie();
49        for(String s: dictionary){
50            t.insert(s);
51        }
52        String arr []= sentence.split(" ");
53        StringBuilder sb = new StringBuilder();
54
55        for(int i=0 ; i<arr.length ; i++){
56            String d = t.search(arr[i]);
57            sb.append(d+" ");
58        }
59
60        return sb.toString().trim();
61    }
62}