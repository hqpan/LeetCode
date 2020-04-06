/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Approach 1: double pointer
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode pre = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                return head;
            }
            pre = curr;
            curr = curr.next;
        }
        return head;
    }
}

// Approach 2: single pointer
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curr = head;
        if (head == null)
            return null;
        if (head.val == val && head.next != null)
            return head.next;
        while (curr != null) {
            if (curr.val == val && curr.next == null) {
                ListNode temp = head;
                while (temp.next != curr)
                    temp = temp.next;
                temp.next = null;
                return head;
            }                
            if (curr.val == val) {
                curr.val = curr.next.val;
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }
}