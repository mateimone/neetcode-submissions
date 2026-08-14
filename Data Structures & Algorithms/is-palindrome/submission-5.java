class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder str = new StringBuilder();
        // for (int i = 0; i < s.length(); i++) {
        //     if (s)
        // }
        if (s.isEmpty()) return false;
        int i = 0, j = s.length()-1;

        while (i < j) {
            char leftLetter = s.charAt(i);
            char rightLetter = s.charAt(j);
            if (!Character.isLetterOrDigit(leftLetter)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightLetter)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(leftLetter) != Character.toLowerCase(rightLetter))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
