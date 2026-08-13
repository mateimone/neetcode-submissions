class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        subset = []
        res = []
        self.dfs(0, target, nums, subset, res)

        return res
    
    def dfs(self, i, target, nums: List[int], subset: List[int], res: List[List[int]]):
        s = sum(subset)
        if s > target:
            return
        if i >= len(nums):
            if s == target:
                res.append(subset.copy())
            return
        
        subset.append(nums[i])
        self.dfs(i, target, nums, subset, res)

        subset.pop(len(subset)-1)
        self.dfs(i+1, target, nums, subset, res)
        