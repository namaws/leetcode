class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        
        dp[0][0] = true;
        for(int r=1; r<=sLen; r++) {
            dp[r][0] = false;
        }
        for(int c=1; c<=pLen; c++) {
            if(p.charAt(c-1) == '*') {
                dp[0][c] = dp[0][c-1];
            }
        }
        
        for(int r=1; r<=sLen; r++) {
            for(int c=1; c<=pLen; c++) {
                
                //r-1 cuz using idx
                if ((s.charAt(r-1) == p.charAt(c-1) || p.charAt(c-1) == '?') && dp[r-1][c-1])
                    dp[r][c] = true;
                else if(p.charAt(c-1) == '*' && (dp[r-1][c] || dp[r][c-1]))
                    dp[r][c] = true;
            }
        }
        return dp[sLen][pLen];
    }
}