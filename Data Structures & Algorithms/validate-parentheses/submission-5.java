class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> opening = new HashSet<>(List.of('{', '[', '('));
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (opening.contains(c)) {
                stack.push(c);
            }
            else {
                if (stack.empty()) 
                    return false;
                
                Character popped = stack.pop();
                if (!correspond(popped, c)) 
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean correspond(char c1, char c2) {
        return (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')');
    }
}
