# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return -1
        return self.helper(root, 0)[0]

    def helper(self, root: Optional[TreeNode], depth: int) -> tuple[int, int]:
        print("yo")
        print(root, depth)
        if root is None:
            return (0, depth-1)

        lrec = self.helper(root.left, depth+1)
        rrec = self.helper(root.right, depth+1)



        root_path_length = lrec[1] + rrec[1] - 2 * depth  # not + 1 because it asks for number of edges!!!!

        if lrec[0] > root_path_length:
            return (max(lrec[0], rrec[0]), max(lrec[1], rrec[1]))
        elif root_path_length > rrec[0]:
            return (root_path_length, max(lrec[1], rrec[1]))
        else:
            return (rrec[0], max(lrec[1], rrec[1]))