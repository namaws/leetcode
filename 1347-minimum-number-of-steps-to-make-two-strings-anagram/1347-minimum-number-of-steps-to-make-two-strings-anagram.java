class Solution {
    public int minSteps(String s, String t) {
        // character 
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            sArr[c1-'a'] += 1;
            tArr[c2-'a'] += 1;
        }
        int cnt = 0;
        // here only calculate one side
        // if count tArr[i] - sArr[i], would count the twice of difference
        for(int i=0; i<26; i++) {
            if(sArr[i] > tArr[i]) {
                cnt += sArr[i]-tArr[i];
            }
        }
        
        return Math.abs(cnt);
    }
}