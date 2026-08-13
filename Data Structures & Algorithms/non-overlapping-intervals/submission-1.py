class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: x[1])
        removed = 0
        last_time = -50001
        for interval in intervals:
            if interval[0] < last_time:
                removed += 1
            else:
                last_time = interval[1]
        
        return removed