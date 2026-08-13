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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = 0, s2 = 0;
        ListNode d1 = l1, d2 = l2;

        int sum = 0;
        boolean remainder = false;
        ListNode creator = null;
        ListNode newHead = new ListNode(0), prev = new ListNode(0);

        while(d1 != null || d2 != null) {
            int v1, v2;

            if (d1 == null) v1 = 0;
            else v1 = d1.val;

            if (d2 == null) v2 = 0;
            else v2 = d2.val;

            int r = remainder ? 1 : 0;
            sum = 0;
            if ((v1 + v2 + r) >= 10) {
                sum += (r + v1 + v2 - 10);
                remainder = true;
            }
            else {
                sum += (r + v1 + v2);
                remainder = false;
            }
            if (creator == null) {
                creator = new ListNode(sum, null);
                newHead = prev = creator;
            }
            else {
                creator = new ListNode(sum, null);
                prev.next = creator;
                prev = creator;
            }
            if (d1 != null)
                d1 = d1.next;
            if (d2 != null)
                d2 = d2.next;
        }

        // if (d1 != null) {
        //     while(d1 != null) {
                
        //     }
        // }
        // else if (d2 != null) {
        //     prev.next = d2;
        // }
        // else {
        //     if (remainder) 
        //         prev.next = new ListNode(1);
        // }
        if (remainder) prev.next = new ListNode(1);

        return newHead;
    }
}
