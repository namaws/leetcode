/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node dummy = new Node(0, null, head, null);
        
        //each dfs flatten one level
        flattenDFS(dummy, head);
        
        // head's prev pointer should be null
        dummy.next.prev = null;
        return dummy.next;
    }
    
    public Node flattenDFS(Node prev, Node curr) {
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        
        Node temp = curr.next;
        //cuz need to see if curr has child
        // yes -> flatten 
        // no -> return itself
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        
        return flattenDFS(tail, temp);
    }
}