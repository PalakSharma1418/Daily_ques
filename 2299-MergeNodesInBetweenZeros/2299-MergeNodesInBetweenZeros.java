// Last updated: 8/6/2025, 4:43:37 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newhead = new ListNode(-1); // dummy node
        ListNode dummy = newhead;
        ListNode tem = head.next; // skip the first 0
        int val = 0;

        while (tem != null) {
            if (tem.val != 0) {
                val += tem.val;
            } else {
                ListNode d = new ListNode(val);
                newhead.next = d;
                newhead = newhead.next;
                val = 0; // reset sum after adding
            }
            tem = tem.next;
        }

        return dummy.next;
    }
}
