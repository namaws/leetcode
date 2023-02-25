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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode middle = slow.next;
        ListNode preMiddle = slow.next = null;
        while(middle != null) {
            ListNode temp = middle.next;
            middle.next = preMiddle;
            preMiddle = middle;
            middle = temp;
        }
        
        ListNode pointer = head;
        while(preMiddle != null) {
            ListNode tmp1 = pointer.next;
            ListNode tmp2 = preMiddle.next;
            pointer.next = preMiddle;
            preMiddle.next = tmp1;
            preMiddle = tmp2;
            pointer = tmp1;
        }
    }
}