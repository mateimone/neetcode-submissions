class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        letters = len(s)
        letter_freq_s = [0 for i in range(31)]
        letter_freq_t = [0 for i in range(31)]
        
        i = 0
        
        while i < letters:
            letter_freq_s[ord(s[i]) - ord('a')] += 1
            letter_freq_t[ord(t[i]) - ord('a')] += 1
            i += 1
        
        return letter_freq_s == letter_freq_t