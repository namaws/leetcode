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
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        
        int cnt = 0;
        while(fast.next != null) {
            fast = fast.next;
            cnt++;
        }
        
        for(int i=cnt-k%cnt; i>0; i--) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
}