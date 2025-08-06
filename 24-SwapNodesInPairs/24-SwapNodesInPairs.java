// Last updated: 8/6/2025, 4:51:21 PM
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null;
        while(first !=null && second!=null){
            ListNode third= second.next;
            second.next=first;
            first.next=third;
            if(prev!=null)  prev.next = second;
            else head= second;
            // update
            prev=first;
            first=third;
            if(third!=null) second=third.next;//There are no more nodes left, so:
            else second=null;
        }
        return head;
    }
}