class Solution {
    public int lengthOfLastWord(String s) {
        int cnt = 0;
        int len = s.length();
        for(int i=len-1; i>=0; i--) {
            if(s.charAt(i) != ' ')
                cnt++;
            else {
                if(s.charAt(i) == ' ' && cnt > 0)
                    break;
            }
        }
        
        return cnt;
    }
}