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
        
        //each while loop flatten one level of the doublelinked list
        while(curr != null) {
            if(curr.child == null) {
                curr = curr.next;
            }
            else {
                Node kid = curr.child;
                while(kid.next != null) {
                    kid = kid.next;
                }
                
                //kid is the last node of the tail
                kid.next = curr.next;
                
                //if next node exist, connect next node and tail
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