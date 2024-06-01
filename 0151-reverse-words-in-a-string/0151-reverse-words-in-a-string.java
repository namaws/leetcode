class Solution {
    public String reverseWords(String s) {
        List<String> strs = new ArrayList();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) !=' ') {
                sb.append(s.charAt(i));
            }
            else {
                if(sb.length() > 0) {
                    strs.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
            if(i == s.length()-1 && sb.length()>0)
                strs.add(sb.toString());
        } 
        
        StringBuilder result = new StringBuilder();
        for(int i=strs.size()-1; i>0; i--) {
            result.append(strs.get(i));
            result.append(" ");
        }
        result.append(strs.get(0));
        return result.toString();
    }
}