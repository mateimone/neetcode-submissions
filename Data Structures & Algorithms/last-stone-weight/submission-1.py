import heapq

class Solution:
    def lastStoneWeight(self, heap: List[int]) -> int:
        # heap = []
        # for stone in stones:
        #     heapq.heappush(heap, stone)
        heapq.heapify_max(heap)
        while len(heap) >= 2:
            sa = heapq.heappop_max(heap)
            sb = heapq.heappop_max(heap)

            if sa != sb:
                sc = abs(sa - sb)
                heapq.heappush_max(heap, sc)
        else:
            if len(heap) == 1:
                return heapq.heappop_max(heap)
            else:
                return 0