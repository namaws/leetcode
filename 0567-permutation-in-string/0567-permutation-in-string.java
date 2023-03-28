class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int[] count = new int[26];
        
        for(int i=0; i<len1; i++) {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        
        if(allZero(count)) return true;
        for(int i=len1; i<len2; i++) {
            //movoing forward a step
            count[s2.charAt(i)-'a']--;
            //moving forward a step
            count[s2.charAt(i-len1)-'a']++;
            if(allZero(count)) return true;
        }
        return false;
    }
    
    private boolean allZero(int[] count) {
        for(int i: count)
            if(i>0) return false;
        return true;
    }
}