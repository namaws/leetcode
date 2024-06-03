class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx1 = 0;
        int idx2 = 0;
        int cnt = 0;
        if(s.length() == 0) return true;
        while(idx1 < s.length() && idx2 < t.length()) {
            if(s.charAt(idx1) == t.charAt(idx2)) {
                cnt++;
                idx1++;
                if(cnt == s.length()) return true;
            }
            idx2++;
        }
        return false;
    }
}