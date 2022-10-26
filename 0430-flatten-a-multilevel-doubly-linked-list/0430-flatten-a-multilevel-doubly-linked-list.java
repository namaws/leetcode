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
    /*
    1. Start form the head , move one step each time to the next node
    2. When meet with a node with child, say node p, follow its child chain to the end and connect the tail node with       p.next, by doing this we merged the child chain back to the main thread
    3. Return to p and proceed until find next node with child.
    4. Repeat until reach null
    */
    public Node flatten(Node head) {
        if(head == null) return null;
        Node node = head;
        while(node != null) {
            //case 1. No child node, move to next node
            if(node.child == null) {
                node = node.next;
                continue;
            }
            
            //case 2. has Child node
            Node temp = node.child;
            
            //find the tail of the child
            while(temp.next != null) {
                temp = temp.next;
            }
            // connect tail to main level
            temp.next = node.next;
            if(node.next != null)
                node.next.prev = temp;
            
            node.next = node.child;
            node.child.prev = node;
            node.child = null;
        }
        return head;
    }

}