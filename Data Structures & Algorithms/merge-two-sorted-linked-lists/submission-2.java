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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode newHead = new ListNode();
        ListNode walker = newHead;
        while (list1 != null && list2 != null) {
            ListNode temp;
            if (list1.val > list2.val) {
                temp = list2;
                list2 = list2.next;
            }
            else {
                temp = list1;
                list1 = list1.next;
            }
            walker.next = temp;
            walker = walker.next;
        }

        if (list1 != null) {
            walker.next = list1;
        }
        if (list2 != null) {
            walker.next = list2;
        }

        return newHead.next;
    }
}