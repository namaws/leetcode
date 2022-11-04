class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /*
        Using recursive function to find the path
        
        */
        
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        curr.add(0);
        helper(graph, result, curr, 0);
        return result;
    }
    
    public void helper(int[][] graph, List<List<Integer>> result, LinkedList<Integer> curr, int node) {
        //base case -> reach the end node -> find the possible path to the end
        if(node == graph.length-1) {
            result.add(new ArrayList(curr));
        }
        
        for(int i=0; i<graph[node].length; i++) {
            int nextNode = graph[node][i];
            curr.add(nextNode);
            helper(graph, result, curr, nextNode);
            curr.removeLast();
        }
    }
}