class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        index = 0
        curGas = 0
        dif = [i-j for i,j in zip(gas,cost)]
        for i in range(len(dif)):
            curGas += dif[i]
            if curGas < 0:
                curGas = 0
                index = i + 1
            # else:
            #     curGas += dif[i]
            #     if index == -1:
            #         index = i
        
        return index

        