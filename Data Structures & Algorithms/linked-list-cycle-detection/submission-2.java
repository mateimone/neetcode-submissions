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
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode walker = head;
        ListNode fastWalker = head;

        do {
            walker = walker.next;
            fastWalker = fastWalker.next;
            if (fastWalker == null) return false;
            fastWalker = fastWalker.next;
        } while (fastWalker != null && fastWalker != walker);

        // System.out.println(fastWalker.val);
        return fastWalker != null;
    }
}
