class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mappings = {
            '2': ['a', 'b', 'c'],
            '3': ['d', 'e', 'f'],
            '4': ['g', 'h', 'i'],
            '5': ['j', 'k', 'l'],
            '6': ['m', 'n', 'o'],
            '7': ['p', 'q', 'r', 's'],
            '8': ['t', 'u', 'v'],
            '9': ['w', 'x', 'y', 'z']
        }
        res = []
        cur = ""
        self.backtrack(mappings, digits, 0, 0, res, cur)

        return res

    def backtrack(self, mappings, digits, digits_index, combination_index, res, cur):
        if digits_index == len(digits):
            if cur != "":
                res.append(cur)
            return

        digit = digits[digits_index]
        letter = mappings[digit][combination_index]
        temp = (cur + letter)
        self.backtrack(mappings, digits, digits_index+1, 0, res, temp)

        if combination_index+1 < len(mappings[digit]):
            self.backtrack(mappings, digits, digits_index, combination_index+1, res, cur)


