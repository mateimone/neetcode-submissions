class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sd = dict()
        td = dict()

        for (sc, tc) in zip(s,t):
            if sc not in sd.keys():
                sd[sc] = 0
            else:
                sd[sc] += 1
            if tc not in td.keys():
                td[tc] = 0
            else:
                td[tc] += 1
        
        for ch in sd.keys():
            if ch not in td.keys():
                return False
            if sd[ch] != td[ch]:
                return False
        
        return True


        