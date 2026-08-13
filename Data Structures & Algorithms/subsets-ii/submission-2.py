class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        subset = []
        res = []

        self.dfs(0, nums, subset, res)
        return res

    def dfs(self, i, nums: List[int], subset: List[int], res: List[List[int]]):
        if i >= len(nums):
            res.append(subset.copy())
            return
        
        subset.append(nums[i])
        self.dfs(i+1, nums, subset, res)

        while i+1 < len(nums) and nums[i] == nums[i+1]:
            i += 1

        subset.pop(len(subset)-1)
        self.dfs(i+1, nums, subset, res)
        
        