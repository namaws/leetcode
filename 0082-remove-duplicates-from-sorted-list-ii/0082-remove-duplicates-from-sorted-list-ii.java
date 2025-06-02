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
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = dummy;

        while(fast != null) {
            //while loop for duplicate value 
            while(fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            
            //remove duplicate
            if(slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            }

            //no duplicate -> do normal step
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}