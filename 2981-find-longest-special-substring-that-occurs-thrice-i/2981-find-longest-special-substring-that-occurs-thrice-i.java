class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap();
        
        for(int start=0; start<s.length(); start++) {
            StringBuilder sb = new StringBuilder();
            
            for(int end=start; end<s.length(); end++) {
                if(sb.length() == 0 || sb.charAt(sb.length()-1) == s.charAt(end)) {
                    sb.append(s.charAt(end));
                    map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
                }
                else break;
            }
        }
        
        int ans = 0;
        for(String str: map.keySet()) {
            if(map.get(str) >= 3 && str.length() > ans) ans = str.length();
        }
        
        if(ans == 0 ) return -1;
        
        return ans;
    }
}