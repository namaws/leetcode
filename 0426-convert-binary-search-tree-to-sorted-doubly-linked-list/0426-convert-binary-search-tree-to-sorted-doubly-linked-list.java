/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        
        Node first = null;
        Node last = null;
        
        Deque<Node> stack = new ArrayDeque<>();
        //if break while loop => every node is linked except for the last one
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(first == null) {
                first = root;
            }
            
            if(last != null) {
                last.right = root;
                root.left = last;
            }
            last = root;
            root = root.right;
        }
        
        first.left = last;
        last.right = first;
        return first;
        
    }
}