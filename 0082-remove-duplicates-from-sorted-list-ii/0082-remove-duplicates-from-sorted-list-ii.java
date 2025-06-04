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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head, prev = dummy;

        while(curr != null) {
            //find duplicate -> skip
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            //if prev.next != curr, meaning there are duplicated nodes need to skip 
            if(prev.next != curr) {
                prev.next = curr.next;
                curr = prev.next;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }   
        return dummy.next;
    }
}