// Last updated: 12/21/2025, 12:35:40 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode mergeKLists(ListNode[] lists) {
13        PriorityQueue<ListNode> pq = new PriorityQueue<>( new Comparator <>(){
14            // @Override
15            public int compare(ListNode o1 , ListNode o2){
16                return o1.val-o2.val;
17            }
18        });
19        ListNode Dummy = new ListNode();
20        ListNode temp=Dummy;
21        for(int i=0;i<lists.length;i++){
22            if(lists[i]!=null){
23                pq.add(lists[i]);
24            }
25        }
26
27        while(!pq.isEmpty()){
28            ListNode r=pq.poll();
29            Dummy.next=r;
30            Dummy = Dummy.next;
31            if(r.next!=null){
32                pq.add(r.next);
33            }
34        }
35        return temp.next;
36    }
37}
38
39// priority queue mai hum na address daal rhe hai bo phir compare nhi honge is we are using (a, b) -> a.val - b.val comparator
40