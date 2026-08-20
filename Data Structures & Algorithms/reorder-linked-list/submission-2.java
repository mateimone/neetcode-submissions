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
        int length = 1;
        int midIndex = -1;
        ListNode walker = head;

        while (walker.next != null) {
            walker = walker.next;
            length++;
        }

        midIndex = length / 2;
        if (length % 2 != 0) {
            midIndex++;
        }

        walker = head;
        ListNode otherHead = null;
        for (int i = 0;i < midIndex-1; i++) {
            walker = walker.next;
        }
        otherHead = walker.next;
        walker.next = null;
        ListNode reversedOtherHead = reverseList(otherHead);
        walker = head;
        ListNode reversedOtherWalker = reversedOtherHead;

        // print(reversedOtherHead);
        // print(walker);

        while (reversedOtherWalker != null) {
            ListNode temp = walker.next;
            ListNode reversedTemp = reversedOtherWalker.next;

            walker.next = reversedOtherWalker;
            reversedOtherWalker.next = temp;

            walker = temp;
            reversedOtherWalker = reversedTemp;
        }
        // if (length % 2 != 0) 

    }

    public void print(ListNode n) {
        System.out.print("[");
        while (n != null) {
            System.out.print(n.val);
            System.out.print(", ");
            n = n.next;
        }
        System.out.println("]");
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
