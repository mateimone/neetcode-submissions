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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode node = new ListNode(head.val);
        ListNode next = head.next;
        while(next != null) {
            ListNode after = next.next;
            ListNode n = new ListNode(next.val, node);
            node = n;
            next = after;
        }
        return node;
    }
}
