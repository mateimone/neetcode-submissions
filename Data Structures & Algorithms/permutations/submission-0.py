class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        return self.interchange(nums, [[]])
    
    def interchange(self, nums, res):
        if len(nums) == 0:
            return [[]]
        one_less = nums.copy()
        popped = one_less.pop(0)
        recurse = self.interchange(one_less, res)
        
        new_res = self.put_everywhere(popped, recurse)

        return new_res

    def put_everywhere(self, num, res):
        new_res = []
        for subset in res:
            i = 0
            cpy = subset.copy()
            while i <= len(cpy):
                cpy.insert(i, num)
                new_res.append(cpy.copy())
                cpy.pop(i)
                i += 1

        return new_res
        