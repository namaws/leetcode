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
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node dummy = new Node(0);
        prev = dummy;
        helper(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
        
    }
    
    public void helper(Node node) {
        if(node == null) return;
        //first keep going to the left most;
        helper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        helper(node.right);
    }
}