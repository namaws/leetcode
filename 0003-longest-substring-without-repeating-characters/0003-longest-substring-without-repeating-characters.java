class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                idx = Math.max(idx, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-idx+1);
        }
        return max;
    }
}