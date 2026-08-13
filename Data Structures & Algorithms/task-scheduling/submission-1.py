import heapq
from collections import deque

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        cycles = 0
        queue = deque()
        heap = []
        d = [0] * 26

        for task in tasks:
            index = ord(task) - ord('A')
            d[index] += 1
        
        for i, freq in enumerate(d):
            if freq == 0:
                continue
            heapq.heappush_max(heap, (freq, chr(i + ord('A'))))
        
        while heap or queue:
            while len(queue) != 0 and cycles == queue[0][0]:
                heapq.heappush_max(heap, queue.popleft()[1])
            if len(heap) == 0:
                cycles += 1
                continue
            
            freq, task = heapq.heappop_max(heap)
            freq -= 1
            cycles += 1

            if freq != 0:
                queue.append((cycles + n, (freq, task)))

        return cycles

        
