class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length()-1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i <= p2;i++) {
            Character c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                Character chr = Character.toLowerCase(c);
                sb.append(chr.toString());
            }
        }
        String a = sb.toString();
        System.out.println(a);
        int p3 = a.length()-1;
        while(p1 <= p3) {
            if (a.charAt(p1) == a.charAt(p3)) {
                p1++;
                p3--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
