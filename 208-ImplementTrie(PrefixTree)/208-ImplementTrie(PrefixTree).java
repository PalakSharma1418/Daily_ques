// Last updated: 2/4/2026, 12:19:30 PM
1public class Trie {
2    class Node{
3        char ch ;
4        boolean isterminal;
5        HashMap<Character,Node> child;
6        public Node(char ch){
7            this.ch=ch;
8            child= new HashMap<>();
9        }
10    }
11
12    private Node root;
13
14    public Trie(){
15        root = new Node('*');
16    }
17    public void insert(String word) {
18        Node curr = root;
19        for(int i=0  ; i<word.length() ; i++){
20            char ch = word.charAt(i);
21            if(curr.child.containsKey(ch)){
22                curr=curr.child.get(ch);
23            }else{
24                Node nn = new Node(ch);
25                curr.child. put(ch,nn);
26                curr= nn ; 
27            }
28        }
29        curr.isterminal = true;
30    }
31    public boolean search(String word) {
32        Node curr = root;
33        for(int i=0  ; i<word.length() ; i++){
34            char ch = word.charAt(i);
35            if(curr.child.containsKey(ch)){
36                curr=curr.child.get(ch);
37            }else{
38                return false; 
39            }
40        }
41        return curr.isterminal;
42    }
43    public boolean startsWith(String prefix) {
44        Node curr = root;
45        for(int i=0  ; i<prefix.length() ; i++){
46            char ch = prefix.charAt(i);
47            if(curr.child.containsKey(ch)){
48                curr=curr.child.get(ch);
49            }else{
50                return false; 
51            }
52        }
53        return true;
54    } 
55}
56