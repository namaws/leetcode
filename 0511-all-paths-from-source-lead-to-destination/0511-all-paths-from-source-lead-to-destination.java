class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap();

        for(int[] edge: edges) {
            map.computeIfAbsent(edge[0], k->new ArrayList()).add(edge[1]);
        }

        if(map.containsKey(destination)) return false;

        return dfs(source, destination, map, new int[n]);
    }

    private boolean dfs (int current, int dest, Map<Integer, List<Integer>> map, int[] states) {
        /*already visit -> check valid or cycle
        if == 2 -> valid -> return true
        if not 2 (meaning 1) -> return false */
        if(states[current] != 0) return states[current] == 2;

        /**
        if map doesn't contain current node, meaning it should be dest, if it is not dest, it stuck */
        if(!map.containsKey(current)) return current == dest;
        
        states[current] = 1;

        for(int node: map.get(current)) {
            if(states[node] == 1 || !dfs(node, dest, map, states)) return false;
        }

        states[current] = 2;
        return true;
    }   
}