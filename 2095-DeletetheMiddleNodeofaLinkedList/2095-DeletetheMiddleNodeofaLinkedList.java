// Last updated: 2/2/2026, 2:32:46 PM
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
12    public ListNode deleteMiddle(ListNode head) {
13        ListNode tem = head;
14        if(head == null || head.next == null) return null;
15        ListNode slow= head;
16        ListNode fast= head;
17        while(fast!=null && fast.next!=null){
18            tem=slow;
19            slow=slow.next;
20            fast=fast.next.next;
21        }
22        tem.next=slow.next;
23        return head;
24
25    }
26}