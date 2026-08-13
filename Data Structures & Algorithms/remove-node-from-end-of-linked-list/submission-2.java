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
        if (head.next == null) return null;
        ListNode curr = head;
        int i = 1;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }
        curr = head;
        ListNode prev = null;
        while (i <= (length - n)) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (prev == null) {
            return head.next;
        }
        else {
            prev.next = curr.next;
        }
        curr = null;

        return head;
    }
}
