class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0]*n
        pref = [0]*n
        suff = [0]*n

        pref[0] = suff[n-1] = 1

        # nums = [a,b,c,d]
        # 1, 1*a, 1*a*b, 1*a*b*c
        # 1*b*c*d, 1*c*d, 1*d, 1

        # b*c*d, a*c*d, a*b*d, a*b*c

        for i in range(1, n):
            pref[i] = nums[i-1] * pref[i-1]
        for i in range(n-2, -1, -1):
            suff[i] = nums[i+1] * suff[i+1]
        for i in range(n):
            res[i] = pref[i] * suff[i]
        
        return res
