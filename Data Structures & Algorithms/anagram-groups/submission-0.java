class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            HashMap<Character, Integer> m = new HashMap<>();
            for (int i = 0;i < s.length();i++) {
                char chr = s.charAt(i);
                Integer val = m.putIfAbsent(chr, 1);
                if(val != null)
                    m.put(chr, val+1);
            }
            if (!map.containsKey(m))
                map.put(m, new ArrayList<>());
            map.get(m).add(s);
        }

        List<List<String>> ls = new ArrayList<>();
        for (List<String> anagrams : map.values()) {
            ls.add(anagrams);
        }

        return ls;
    }
}
