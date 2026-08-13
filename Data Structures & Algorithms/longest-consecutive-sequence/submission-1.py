class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        d = {}
        for num in nums:
            d[num] = None
        
        max_length = 1
        curr_length = 1
        for num in nums:
            if d[num] is not None:
                continue
            d[num] = 1
            temp = num + 1
            while temp in d.keys():
                curr_length += 1
                d[temp] = d[temp-1] + 1
                temp += 1
            if curr_length > max_length:
                max_length = curr_length
            curr_length = 1

        return max_length
                    


        