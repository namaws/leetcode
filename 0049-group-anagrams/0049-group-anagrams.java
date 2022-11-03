class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for(String s: strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            if(!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList());
            map.get(sortedStr).add(s);
        }
        
        return new ArrayList(map.values());
    }
}