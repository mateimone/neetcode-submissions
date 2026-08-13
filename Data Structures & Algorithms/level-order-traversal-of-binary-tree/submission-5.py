# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        d = deque()
        res = [[]]

        d.append(root)
        
        childrenToLookAt = 1
        nextGenSize = 0
        while len(d) != 0:
            curr = d.popleft()
            childrenToLookAt -= 1
            res[-1].append(curr.val)

            if curr.left:
                d.append(curr.left) 
                nextGenSize += 1
            if curr.right:
                d.append(curr.right)
                nextGenSize += 1

            if childrenToLookAt == 0:
                res.append([])
                childrenToLookAt = nextGenSize
                nextGenSize = 0
        res.pop()
        return res
            

            
