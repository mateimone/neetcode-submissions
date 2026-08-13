class Solution:
    def isValid(self, s: str) -> bool:
        openR = openB = openC = 0 
        lastOpened = []
        for c in s:
            if c == '(':
                lastOpened.append(c)
            elif c == '[':
                lastOpened.append(c)
            elif c == '{':
                lastOpened.append(c)
            else:
                if len(lastOpened) == 0:
                    return False
                opener = lastOpened[-1]
                if (c == ')' and opener != '(') or \
                   (c == ']' and opener != '[') or \
                   (c == '}' and opener != '{'):
                   return False
                lastOpened.pop(-1)
        
        if len(lastOpened) != 0:
            return False
        return True
                