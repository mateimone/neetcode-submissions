class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        res = []
        return self.dfs(0, nums, subset, res)

    def dfs(self, i, nums: List[int], subset: List[int], res: List[List[int]]) -> List[List[int]]:
        if i >= len(nums):
            res.append(subset.copy())
            return
        
        subset.append(nums[i])
        self.dfs(i+1, nums, subset, res)

        subset.pop(len(subset)-1)
        self.dfs(i+1, nums, subset, res)

        return res
