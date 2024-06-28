class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap();
        Map<Character, Character> tMap = new HashMap();
        
        for(int i=0; i<s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if(sMap.containsKey(sC) && tMap.containsKey(tC)) {
                if(sMap.get(sC) != tC) return false;
            }
            
            else if(!sMap.containsKey(sC) && !tMap.containsKey(tC)) {
                sMap.put(sC, tC);
                tMap.put(tC, sC);
            }
            else 
                return false;
        }
        return true;
    }
}