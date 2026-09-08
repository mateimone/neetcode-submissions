# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        stack = [root]

        while len(stack) != 0: 
            node = stack.pop()
            if node == None:
                continue
            if node.val == subRoot.val:
                res = self.checkSubRoot(node, subRoot)
                if res:
                    return True
            stack.append(node.left)
            stack.append(node.right)
        
        return False


    def checkSubRoot(self, root, subroot):
        if root == None and subroot == None:
            return True
        
        if root != None and subroot != None and root.val == subroot.val:
            return self.checkSubRoot(root.left, subroot.left) and self.checkSubRoot(root.right, subroot.right)
        else:
            return False
