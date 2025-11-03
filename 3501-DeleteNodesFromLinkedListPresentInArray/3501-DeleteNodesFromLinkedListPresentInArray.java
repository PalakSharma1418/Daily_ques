// Last updated: 11/3/2025, 8:24:35 PM
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> map = new HashSet<>();
        for (int x : nums) map.add(x);
        while (head != null && map.contains(head.val)) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            while (curr.next != null && map.contains(curr.next.val)) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}