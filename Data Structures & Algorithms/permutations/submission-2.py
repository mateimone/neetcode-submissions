class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        subset = []
        index = 0
        self.backtrack(res, subset, index, nums, len(nums))

        return res

    def backtrack(self, res, subset, index, nums, length):
        if len(subset) == length:
            res.append(subset.copy());
            return

        subset.append(nums[index])
        popped = nums.pop(index)
        self.backtrack(res, subset, 0, nums, length)

        subset.pop(len(subset)-1)
        nums.insert(index, popped)
        if index <= len(nums)-2:
            self.backtrack(res, subset, index+1, nums, length)

