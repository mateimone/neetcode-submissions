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
    public boolean hasCycle(ListNode head) {
        ListNode p1, p2;
        p1 = p2 = head;

        do {
            p1 = p1.next;
            if (p2.next == null) return false;
            p2 = p2.next.next;
        } while(p1 != p2 && p2 != null);

        return p1 == p2;
    }
}
