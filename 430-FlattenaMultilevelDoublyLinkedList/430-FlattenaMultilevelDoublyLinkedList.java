// Last updated: 2/6/2026, 12:34:07 PM
1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public Node prev;
6    public Node next;
7    public Node child;
8};
9*/
10
11class Solution {
12    public Node flatten(Node head) {
13        if (head == null) return head;
14
15        Stack<Node> stack = new Stack<>();
16        Node curr = head;
17
18        while (curr != null) {
19
20            // If child exists → go DOWN first
21            if (curr.child != null) {
22
23                // Save next for later (backtracking)
24                if (curr.next != null) {
25                    stack.push(curr.next);
26                }
27
28                // Attach child as next
29                curr.next = curr.child;
30                curr.next.prev = curr;   // taki nye node mai phele ka dat store ho jaye jese hi mai aage nyi value dalu to phle ki se connect kar du
31                curr.child = null;
32            }
33
34            // If next is null → return to saved node
35            if (curr.next == null && !stack.isEmpty()) {
36                Node temp = stack.pop();
37                curr.next = temp;
38                temp.prev = curr;        // IMPORTANT
39            }
40
41            curr = curr.next;
42        }
43
44        return head;
45    }
46}
47