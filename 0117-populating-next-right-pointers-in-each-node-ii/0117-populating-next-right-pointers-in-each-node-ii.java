/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node curr = q.poll();
                size--;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);

                if(size == 0) curr.next = null;
                if(size > 0) curr.next = q.peek();
            }
        }
        return root;
    }
}