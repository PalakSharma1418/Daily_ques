// Last updated: 8/6/2025, 4:42:15 PM
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;

        while(temp != null && temp.next != null){
             int a =temp.val;
            int b= temp.next.val;
            int g= gcd(a,b);
            ListNode gcd = new ListNode(g);
            ListNode help=temp.next;
            temp.next=gcd;
            gcd.next=help;
            temp=temp.next.next;
        }

        return head;
    }
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}