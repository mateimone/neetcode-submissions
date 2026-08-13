class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        char[] str = s.toCharArray();
        for(int i = 0;i < str.length;i++) {
            int l, r;
            l = r = i;
            while(l >= 0 && r < str.length && str[l] == str[r]) {
                if (res.length() < r-l+1) {
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }   
            l = i;
            r = i+1;
            while(l >= 0 && r < str.length && str[l] == str[r]) {
                if (res.length() < r-l+1) {
                    res = s.substring(l, r+1);
                }
                l--;
                r++;
            }   
        }

        return res;
    }
}
