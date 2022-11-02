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
        if(head == null) return null;
        
        Node curr = head;
        while(curr!=null) {
            if(curr.child == null) {
                curr = curr.next;
            }
            
            else {
                Node kid = curr.child;
                
                while(kid.next != null) {
                    kid = kid.next;
                }
                
                kid.next = curr.next;
                
                if(curr.next != null) {
                    curr.next.prev = kid;
                }
                
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
        }
        
        return head;
    }
}