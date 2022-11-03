/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList();
        Queue<Node> q = new LinkedList();
        List<List<Integer>> list = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> curr = new LinkedList<>();
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                curr.add(node.val);
                if(i == size-1) {
                    list.add(new ArrayList(curr));
                }
                List<Node> child = node.children;
                for(Node n: child) {
                    q.add(n);
                }
            }
        }
        return list;
    }
}