class Solution {
    public boolean isAnagram(String s, String t) {
        //key, value -> char, count
        Map<Character, Integer> map = new HashMap();
        
        if(s.length() != t.length()) return false;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                if(cnt <= 0) return false;
                map.put(c, cnt-1);
            }
            else
                return false;
        }
        return true;
    }
}