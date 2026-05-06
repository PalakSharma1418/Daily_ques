// Last updated: 5/6/2026, 7:43:00 PM
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
12    public ListNode rotateRight(ListNode head, int k) {
13        if (head == null || head.next == null) return head;
14        int size = getSize(head);
15        k %= size;
16        if (k == 0) return head;
17        int newHeadPosition = size - k;
18        ListNode temp = head;
19        for (int i = 1; i < newHeadPosition; i++) {
20            temp = temp.next;
21        }
22        ListNode newHead = temp.next;
23        temp.next = null;
24        ListNode lastNode = getLastNode(newHead);
25        lastNode.next = head;
26        return newHead;
27    }
28    private int getSize(ListNode head) {
29        int count = 0;
30        ListNode temp = head;
31        while (temp != null) {
32            count++;
33            temp = temp.next;
34        }
35        return count;
36    }
37    private ListNode getLastNode(ListNode head) {
38        ListNode temp = head;
39        while (temp.next != null) {
40            temp = temp.next;
41        }
42        return temp;
43    }
44}