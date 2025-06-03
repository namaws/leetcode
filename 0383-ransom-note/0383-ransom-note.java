class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //magazine dict k,v -> letter, cnt
        Map<Character, Integer> dict = new HashMap();
        for(int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(dict.containsKey(c)) {
                dict.put(c, dict.get(c)-1);//update the number in value
                if(dict.get(c) == 0) dict.remove(c);//if 0, remove the key value pair
            }
            else
                return false;
        }
        return true;
    }
}