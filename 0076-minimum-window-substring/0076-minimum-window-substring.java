class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 < len2) return "";
        
        Map<Character, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        
        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        boolean flag = false;
        int matched = 0;
        int start = 0;
        int subStrStart = 0;
        int minLen = s.length();
        for(int end=0; end<len1; end++) {
            //find match
            char cEnd = s.charAt(end);
            if(map.containsKey(cEnd)) {
                map.put(cEnd, map.get(cEnd)-1);
                if(map.get(cEnd) == 0) matched++;
            }
            
            //already matched everything, try to compare the previous min length
            while(map.size()==matched) {
                flag = true;
                if(minLen > end-start+1) {
                    minLen = end-start+1;
                    subStrStart = start;
                }
                //start adding previous remove character
                char cDeleted = s.charAt(start);
                if(map.containsKey(cDeleted)) {
                    //refresh matched number
                    if(map.get(cDeleted)==0) matched--;
                    map.put(cDeleted, map.get(cDeleted)+1);
                }
                start++;
            }
        }
        return flag == true ? s.substring(subStrStart, subStrStart+minLen):"";
    }

}