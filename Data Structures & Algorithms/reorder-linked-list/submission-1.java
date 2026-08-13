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
    public void reorderList(ListNode head) {
        ListNode creator = head;
        ListNode dummy = head;
        int len = 0;
        while(dummy != null) {
            len++;
            dummy = dummy.next;
        }

        dummy = head;
        System.out.println(Math.ceil(len/2.0));
        for(int i = 0, c = (int) Math.ceil(len/2.0);i < c-1;i++) {
            dummy = dummy.next;
        }
 
        ListNode k = dummy.next;
        dummy.next = null;
        dummy = k;

        dummy = reverseList(dummy);
        while(dummy != null) {
            ListNode next = creator.next;
            ListNode dummyNext = dummy.next;
            creator.next = dummy;
            dummy.next = next;
            
            dummy = dummyNext;
            creator = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(true) {
            curr.next = dummy;
            dummy = curr;
            curr = next;
            if (curr == null) break;
            next = curr.next;
        }

        return dummy;
    }
}
