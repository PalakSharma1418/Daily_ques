// Last updated: 8/6/2025, 4:51:28 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        
        // If we need to remove the head
        if (n == len) {
            return head.next;
        }
        // Find the node just before the one we want to remove
        ListNode prev = getNode(head, (len - n) - 1);
        ListNode curr = prev.next;
        // Remove the nth node from end
        prev.next = curr.next;
        curr.next = null;
        return head;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    private ListNode getNode(ListNode head, int index) {
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
