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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preRange = new ListNode(0, head);
        ListNode prev = preRange;
        ListNode curr = head;
        int cnt = 1;
        while(curr != null) {
            //start to reverse
            if(cnt == left) {
                ListNode temp = curr.next;
                prev.next = null;
                prev = curr;
                curr = temp;
                prev.next = null;
            }
            
            else if(cnt > left && cnt <= right) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            else if(cnt > right) {
                break;
            }
            
            else {
                prev = prev.next;
                curr = curr.next;
            }
            cnt++;
        }
        ListNode dummy = preRange;
        while(preRange.next != null) {
            preRange = preRange.next;
        }
        
        preRange.next = prev;
        
        while(preRange.next != null) {
            preRange = preRange.next;
        }
        
        preRange.next = curr;
        
        return dummy.next;
    }
}