// Last updated: 2/2/2026, 3:28:49 PM
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
12    public int[] nextLargerNodes(ListNode head) {
13        ListNode temp=head;
14        int sz=0;
15        while(temp!=null){
16            sz++;
17            temp=temp.next;
18        }
19        int in=0;
20        int[] ans=new int[sz];
21        
22        Stack<int[]> st=new Stack<>();
23        temp=head;
24        while(temp!=null){
25            while(!st.isEmpty()&&st.peek()[1]<temp.val){
26                ans[st.pop()[0]]=temp.val;
27            }
28            st.push(new int[]{in,temp.val});
29            in++;
30            temp=temp.next;
31        }
32        return ans;
33
34    }
35}