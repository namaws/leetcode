class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split("\\s+");
        if(pattern.length() != strs.length) return false;
        Map<String, Integer> sMap = new HashMap();
        Map<Character, Integer> pMap = new HashMap();
        char[] patterns = pattern.toCharArray();
        int sCnt = 0;
        int pCnt = 0;
        int[] sArr = new int[strs.length];
        int[] pArr = new int[strs.length];
        for(int i=0; i<patterns.length; i++) {
            if(!pMap.containsKey(patterns[i])) {
                pCnt += 1;
                pMap.put(patterns[i], pCnt);
            }
            pArr[i] = pMap.get(patterns[i]);
            if(!sMap.containsKey(strs[i])) {
                sCnt += 1;
                sMap.put(strs[i], sCnt);
            }
            sArr[i] = sMap.get(strs[i]);
        }
        
        for(int i=0; i<pArr.length; i++) {
            if(pArr[i] != sArr[i])
                return false;
        }
        return true;
    }
    
}