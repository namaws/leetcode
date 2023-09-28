class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            arr[c1-'a']++;
            arr[c2-'a']--;
        }
        for(int num:arr)
            if(num != 0)
                return false;
    
        return true;
    }
}