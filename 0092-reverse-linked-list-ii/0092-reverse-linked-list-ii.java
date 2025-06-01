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
            //remove the connection for the first node (need to re-connect later)
            if(cnt == left) {
                ListNode temp = curr.next;
                prev.next = null;
                curr.next = null;
                prev = curr;
                curr = temp;
            }
            //reverse next pointer
            else if(cnt > left && cnt <= right) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            else if(cnt > right) break;
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

        //prev is the first node (right) of the reverse list
        preRange.next = prev;

        while(preRange.next != null) {
            preRange = preRange.next;
        }
        //curr is the first node after the reverse list
        preRange.next = curr;
        return dummy.next;

    }
}