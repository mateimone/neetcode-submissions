class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        x = dict()
        for i in range(len(nums)):
            if target - nums[i] in x:
                if i == x[target-nums[i]]:
                    continue
                return [i, x[target-nums[i]]] if i < x[target-nums[i]] else [x[target-nums[i]], i]
            x[nums[i]] = i
        