class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        elif len(s) == 1:
            return 1
        seen = dict()
        i, j = 0, 1
        maxLen = 0
        seen[s[i]] = i
        while j < len(s):
            if not (s[j] in seen) or seen[s[j]] < i:
                seen[s[j]] = j
            else:
                i = seen[s[j]] + 1
                seen[s[j]] = j
            length = j - i + 1
            if length > maxLen:
                maxLen = length
            j += 1
        return maxLen
