// Last updated: 8/11/2026, 6:42:14 PM
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
12    public ListNode sortList(ListNode head) {
13        if(head==null || head.next==null){
14            return head;
15        }
16        ListNode mid=middle(head);
17        ListNode headB=mid.next;
18        mid.next=null;
19        ListNode a=sortList(head);
20        ListNode b=sortList(headB);
21        return Merge(a,b);
22    }
23    public ListNode Merge(ListNode list1, ListNode list2){
24        ListNode dummy=new ListNode();
25        ListNode temp=dummy;
26        while(list1!=null && list2!=null){
27            if(list1.val<list2.val){
28                dummy.next=list1;
29                dummy=dummy.next;
30                list1=list1.next;
31            }
32            else{
33                dummy.next=list2;
34                dummy=dummy.next;
35                list2=list2.next;
36            }
37        }
38        if(list1==null){
39            dummy.next=list2;
40        }
41        if(list2==null){
42            dummy.next=list1;
43        }
44        return temp.next;
45    }
46    public ListNode middle(ListNode head){
47        ListNode slow=head;
48        ListNode fast=head.next;
49        while(fast!=null && fast.next!=null){
50            fast=fast.next.next;
51            slow=slow.next;
52        }
53        return slow;
54    }
55}