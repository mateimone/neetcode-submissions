class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        subset = []
        res = []
        candidates.sort()
        self.dfs(0, target, candidates, subset, res)
        
        return res

    def dfs(self, i, target, candidates, subset, res):
        s = sum(subset)
        if s == target:
            # for el in res:
            #     if set(el) == set(subset):
            #         return
            res.append(subset.copy())
            return
        
        if i >= len(candidates) or s > target:
            return
        
        subset.append(candidates[i])
        self.dfs(i+1, target, candidates, subset, res)

        while i + 1 < len(candidates) and candidates[i] == candidates[i+1]:
            i += 1

        subset.pop(len(subset)-1)
        self.dfs(i+1, target, candidates, subset, res)

        