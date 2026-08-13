class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1:
            return 0

        profit = 0
        i, j = 0, 1
        while i != j and j < len(prices) and i < len(prices):
            if prices[i] < prices[j]:
                possibleProfit = prices[j] - prices[i]
                if profit < possibleProfit:
                    profit = possibleProfit
            else:
                i = j
            j += 1

        return profit
        