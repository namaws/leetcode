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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(list1 != null || list2 != null) {
            if(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    dummy.next = list1;
                    list1 = list1.next;
                    dummy = dummy.next;
                    System.out.println("Dummy to list1: " + dummy.val);
                }
                else {
                    dummy.next = list2;
                    list2 = list2.next;
                    dummy = dummy.next;
                    System.out.println("Dummy to list2: " + dummy.val);
                }
            }
            
            else if(list1 == null) {
                dummy.next = list2;
                System.out.println("only list2: " + dummy.val);
                break;
            }
            else {
                dummy.next = list1;
                System.out.println("only list1: " + dummy.val);
                break;
            }
        }
        return head.next;
    }
}