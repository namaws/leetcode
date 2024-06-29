class Solution {
    public boolean wordPattern(String pattern, String s) {
//        Map<Character, List<Integer>> pMap = new HashMap();
//        Map<String, List<Integer>> sMap = new HashMap();
        //split s into String array
        String[] strs = s.split("\\s+");
        char[] patterns = pattern.toCharArray();
        
        if(strs.length != patterns.length) return false;
        Map<Character, String> map = new HashMap();
        
        for(int i=0; i<strs.length; i++) {
            if(!map.containsKey(patterns[i])) {
                //already have matching
                if(map.containsValue(strs[i]))
                    return false;
                
                map.put(patterns[i], strs[i]);
            }
            
            else {
                if(!map.get(patterns[i]).equals(strs[i]))
                    return false;
            }
            
        }
        return true;
        
    }
}