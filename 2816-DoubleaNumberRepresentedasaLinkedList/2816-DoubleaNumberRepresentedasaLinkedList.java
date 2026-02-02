// Last updated: 2/2/2026, 2:58:54 PM
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
12    public ListNode doubleIt(ListNode head) {
13        // ListNode heahnew = head;
14        head = reverse(head);
15        int carry =0 ;
16        int val =0 ;
17        ListNode curr = head;
18        while(curr!=null){
19            int sum = curr.val*2+carry;
20            int d = sum%10;
21            curr.val = d;
22            carry = sum/10;
23            if (curr.next == null && carry > 0) {
24                curr.next = new ListNode(carry);
25                carry = 0;
26                break;
27            }
28            curr = curr.next;
29            
30        }
31        return reverse(head);
32    }
33    public static ListNode reverse(ListNode head){
34        //ListNode tem = null ; 
35        ListNode prev = null; 
36        ListNode curr =head;
37        while(curr!=null){
38            ListNode next = curr.next;
39            curr.next=prev;
40            prev=curr;
41            curr=next;
42        }
43        return prev;
44    }
45}