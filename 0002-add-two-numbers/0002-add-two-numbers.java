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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        boolean overflow = false;
        ListNode res = dummy;
        int val = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                val = l2.val;
                l2 = l2.next;
            }
            else if(l2 == null) {
                val = l1.val;
                l1 = l1.next;
            }
            else {
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            if(overflow) {
                val++;
            }
            if(val >= 10) {
                overflow = true;
                val%=10;
            }
            else overflow = false;
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }

        if(overflow) dummy.next = new ListNode(1);
        return res.next;
    }
}