class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap();
        
        for(int i=0; i<s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            
            if(!map.containsKey(sC)) {
                if(map.containsValue(tC))
                    return false;
                else
                    map.put(sC, tC);
            }
            else {
                if(map.get(sC) != tC)
                    return false;
            }
        }
        return true;
    }
}