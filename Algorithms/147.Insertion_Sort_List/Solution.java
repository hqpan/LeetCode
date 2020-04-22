/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode helper = new ListNode(-1);
        ListNode curr = helper;
        ListNode unsorted = head;
        while (unsorted != null) {
            ListNode nextNode = unsorted.next;
            while (curr.next != null && curr.next.val < unsorted.val)
                curr = curr.next;            
            unsorted.next = curr.next;
            curr.next = unsorted;
            curr = helper;
            unsorted = nextNode;
        }
        return helper.next;
    }
}