class Solution {
    public boolean wordPattern(String pattern, String s) {
        
    
        //Mapping for pattern chracter and string
        Map<Character, String> map = new HashMap();
        
        //loop through pattern
        //1. if both non-exist -> new mapping
        //2. if key not exist but value exist -> return false
        //3. if key exist -> check if value is the same
        //time complexity O(n)
        //space complexity O(n)
        
        String[] strs = s.split("\\s+");
        char[] charArr = pattern.toCharArray();
        
        if(strs.length != charArr.length) return false;
        for(int i=0; i<strs.length; i++) {
            if(!map.containsKey(charArr[i])) {
                if(map.containsValue(strs[i]))
                    return false;
                else
                    map.put(charArr[i], strs[i]);
            }
            else {
                if(!map.get(charArr[i]).equals(strs[i]))
                    return false;
            }
        }
        return true;
    }
}