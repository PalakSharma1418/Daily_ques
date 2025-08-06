// Last updated: 8/6/2025, 4:45:40 PM
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
    public int getDecimalValue(ListNode head) {
        int n= size(head)-1;
        int a=0;
        while(head!=null){
            int val= head.val;
            a = a + val * (int)Math.pow(2, n); 
            n--;
            head=head.next;

        }
        return a;
    }
    public int size(ListNode head){
        int s=0;
        while(head!=null){
            s++;
            head=head.next;
        }
        return s;
    }
}