class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for t in tokens:
            try:
                n = int(t)
                stack.append(n)
            except:
                a = stack.pop(-1)
                b = stack.pop(-1)
                stack.append(self.calc_res(b, a, t))
            
            print(stack)
            
        return stack.pop(-1)
    
    def calc_res(self, a, b, t):
        print(a, b, t)
        match t:
            case "+":
                return a + b
            case "*":
                return a * b
            case "-":
                return a - b
            case "/":
                return int(float(a) / b)

            