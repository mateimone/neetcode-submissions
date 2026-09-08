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

class Solution {
    public int maxDepth(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair node = stack.pop();
            if (node.root() == null) continue;
            if (maxDepth < node.depth())
                maxDepth = node.depth();

            stack.push(new Pair(node.root().left, node.depth() + 1));
            stack.push(new Pair(node.root().right, node.depth() + 1));
        }

        return maxDepth;
    }

    public record Pair(TreeNode root, int depth) {

    }
}
