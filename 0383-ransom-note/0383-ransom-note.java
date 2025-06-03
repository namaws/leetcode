class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(int i=0; i<magazine.length(); i++) {
            cnt[magazine.charAt(i)-'a']++;
        }

        for(int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            cnt[c-'a']--;
            if(cnt[c-'a']<0) return false;
        }
        return true;
    }
}