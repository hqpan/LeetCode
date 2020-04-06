/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0)
            return null;
        ListNode ahead = head;
        ListNode behind = head;
        while (k > 1) {
            if (ahead == null)
                return null;
            ahead = ahead.next;
            --k;
        }
        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }
}