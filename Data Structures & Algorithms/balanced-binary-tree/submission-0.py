# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        return self.helper(root)[0]
        
    def helper(self, root: Optional[TreeNode]) -> Tuple[bool, int]:
        if root is None:
            return (True, 0)
        
        lb, lh = self.helper(root.left)
        rb, rh = self.helper(root.right)

        if not lb or not rb:
            return (False, -1)
        
        if abs(lh - rh) > 1:
            return (False, -1)
        
        return (True, max(lh, rh) + 1)
