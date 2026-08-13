class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        res = [0] * len(temperatures)

        i = 0
        for temp in temperatures:
            while len(stack) != 0 and stack[-1][0] < temp:
                lower = stack.pop()
                res[lower[1]] = i - lower[1]
            
            stack.append((temp, i))
            i += 1

        return res