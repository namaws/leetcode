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
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        int cnt = 0;
        while(curr != null) {
            curr = curr.next;
            cnt++;
        }

        curr = dummy;
        k = k%cnt;
        if(k == 0) return head;
        
        for(int i=0; i<cnt-k; i++) {
            curr = curr.next;
        }
        ListNode tail = curr.next;
        curr.next = null;
        ListNode newHead = tail;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = dummy.next;
        return newHead;
    }
}