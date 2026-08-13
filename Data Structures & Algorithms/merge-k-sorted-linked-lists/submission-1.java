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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> res = new ArrayList<>();
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
        for(ListNode n : lists) pq.offer(n);
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            res.add(node);
            if (node.next != null) pq.offer(node.next);
        }
        if (res.isEmpty()) {
            System.out.println("HELLO");
            return null;
        }
        ListNode root = res.get(res.size()-1);
        for(int i = res.size()-2;i >= 0;i--) {
            ListNode node = res.get(i);
            ListNode bigg = new ListNode(node.val, root);
            root = bigg;
        }

        return root;
    }
}
