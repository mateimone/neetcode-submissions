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
    public int goodNodes(TreeNode root) {
        return helper(root.left, root.val) + helper(root.right, root.val) + 1;
    }

    public int helper(TreeNode root, int maxValue) {
        if (root == null) return 0;
        int goodNode = 0;
        
        if (root.val >= maxValue) {
            goodNode += 1;
            maxValue = root.val;
        }

        int leftGoodNodes = helper(root.left, maxValue);
        int rightGoodNodes = helper(root.right, maxValue);

        return leftGoodNodes + rightGoodNodes + goodNode;
    }
}
