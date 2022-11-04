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
        int size1 = size(l1);
        int size2 = size(l2);
        ListNode resHead = null;
        ListNode curr = null;
        while(l1 != null || l2 != null) {
            int val = 0;
            if(size1 >= size2) {
                val += l1 != null ? l1.val:0;
                l1 = l1.next;
                size1--;
            }
            //compare with size1+1 cuz size1 might has been deducted
            if(size2 >= size1+1) {
                val += l2 != null ? l2.val: 0;
                l2 = l2.next;
                size2--;
            }
            
            curr = new ListNode(val);
            curr.next = resHead;
            resHead = curr;
        }
        
        int carry = 0;
        resHead = null;
        
        while(curr != null) {
            int val = (carry + curr.val) %10;
            carry = (carry+curr.val)/10;
            
            curr = curr.next;
            
            ListNode node = new ListNode(val);
            node.next = resHead;
            resHead = node;
        }
        
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = resHead;
            resHead = node;
        }
        return resHead;
    }
    
    private int size(ListNode l) {
        int s = 0;
        while (l != null) {
            l = l.next;
            s++;
        }
        return s;
    }
}