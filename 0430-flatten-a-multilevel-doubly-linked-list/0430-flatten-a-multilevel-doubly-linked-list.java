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
        // make sure the 'prev' pointer is never gone
        Node dummy = new Node(0, null, head, null);
        
        dfs(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
        
    }
    
    public Node dfs(Node prev, Node curr) {
       if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        
        Node tempNext = curr.next;
        Node tail = dfs(curr, curr.child);
        curr.child = null;
        
        return dfs(tail, tempNext);
    }

}