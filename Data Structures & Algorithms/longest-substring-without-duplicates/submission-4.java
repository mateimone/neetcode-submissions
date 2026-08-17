class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int i1, i2;
        i1 = 0;
        i2 = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i1));
        int currLen = 1;

        while (i2 < s.length()) {
            char c = s.charAt(i2);
            if (!set.contains(c)) {
                set.add(c);
            }
            else {
                while(set.contains(c)) {
                    set.remove(s.charAt(i1));
                    i1++;
                }
                set.add(c);
            }
            i2++;
            currLen = Math.max(currLen, set.size());
        }

        return currLen;
    }
}
