/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        //nothing to rotate, return as is

        //2. find the length
        ListNode tail = head;
        int length = 1; //head is one
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;//point tail to the head making it circular

        k = k % length; // k could be larger than list length
        if(k == 0) {
            tail.next = null;
            return head;
        }

        //find the new head
        ListNode newTail = head;

        for(int i=0; i<length-k-1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}