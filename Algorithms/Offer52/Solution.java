/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Approach1: Hash table
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        HashMap<ListNode, Integer> st = new HashMap<>();
        ListNode curr = headA;
        while (curr != null) {
            st.put(curr, 0);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (st.containsKey(curr))
                return curr;
            curr = curr.next;
        }
        return null;
    }
}

// Approach2: Two Pointers
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        int diff = Math.abs(lengthA - lengthB);
        ListNode currA = lengthA >= lengthB ? headA : headB;
        ListNode currB = lengthA >= lengthB ? headB : headA;
        while (diff-- > 0)
                currA = currA.next;
        while (currA != null) {
            if (currA.equals(currB))
                return currA;
            currA = currA.next;
            currB = currB.next;            
        }
        return null;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }
}