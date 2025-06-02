class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;

        Map<String, Set<String>> map = new HashMap();
        //create graph
        for(List<String> pair: similarPairs) {
            map.computeIfAbsent(pair.get(0), k-> new HashSet()).add(pair.get(1));
            map.computeIfAbsent(pair.get(1), k-> new HashSet()).add(pair.get(0));
        }

        for(int i=0; i<sentence1.length; i++) {
            String str1 = sentence1[i], str2 = sentence2[i];
            if(str1.equals(str2)) continue;
            if(map.containsKey(str1) && map.containsKey(str2) && dfs(str1, str2, map, new HashSet()))
                continue;
            return false;
        }
        return true;
    }

    private boolean dfs(String node, String dest, Map<String, Set<String>> map, Set<String> visited) {
        if(node.equals(dest)) return true;
        visited.add(node);

        if(!map.containsKey(node)) return false;

        for(String neighbor: map.get(node)) {
            if(!visited.contains(neighbor)) {
                if(dfs(neighbor, dest, map, visited)) return true;
            }
        }
        return false;
    }
}