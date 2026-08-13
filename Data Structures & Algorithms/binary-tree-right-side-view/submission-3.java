/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Per {
    TreeNode node;
    int depth;

    public Per(TreeNode n, int d) {
        node = n;
        depth = d;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<Per> q = new LinkedList<>();
        q.add(new Per(root, 0));

        while (!q.isEmpty()) {
            Per p = q.poll();
            if (list.size() == p.depth) {
                list.add(p.node.val);
            }

            if (p.node.right != null)
                q.add(new Per(p.node.right, p.depth+1));
            if (p.node.left != null)
                q.add(new Per(p.node.left, p.depth+1));
        }

        return list;
    }
}
