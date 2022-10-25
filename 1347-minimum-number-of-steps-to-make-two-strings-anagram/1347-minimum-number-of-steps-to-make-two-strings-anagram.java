class Solution {
    public int minSteps(String s, String t) {
        // character 
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            count[c1-'a']++;
            count[c2-'a']--;
        }
        int cnt = 0;
        for (int i=0; i<26; i++) {
            if (count[i] > 0) {
                cnt += count[i];
            }
        }
        return cnt;
    }
}