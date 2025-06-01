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

 /**
public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
} */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode result = dum;
        int val = 0;
        boolean carry = false;
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
                val = l1.val+l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            //previous carry over
            if(carry) val += 1;

            if(val >= 10) {
                carry = true;
                val %= 10;
            }
            else
                carry = false;
            
            ListNode curr = new ListNode(val);
            dum.next = curr;
            dum = dum.next;
        }
        if(carry) {
            ListNode curr = new ListNode(1);
            dum.next = curr;
        }
        return result.next;
    }
}