[TOC]



# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 160 & 剑指 Offer 52

## 1.1 复杂度分析

- 暴力求解：==无需复习==
  - 时间复杂度：$O(mn)$；
  - 空间复杂度：$O(1)$；
- 哈希表：
  - 时间复杂度：$O(m+n)$；
  - 空间复杂度：$O(m)$；
- 双指针：
  - 时间复杂度：$O(m+n)$；
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 52；

## 1.2 哈希表

- 解题思路：
  - 遍历第一条链表，以节点为键，任意元素为值，存入哈希表中；
  - 遍历第二条链表，依次检测哈希表中是否存在当前节点；
  - 注意：哈希表可在$O(1)$下检测某元素是否存在或某特定键对应的值；

```java
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
```

## 1.3 双指针

- 解题思路：当两条链表存在公共部分，则遍历最后若干节点时，具有相同结果；
  - 遍历两条链表，求得链表长度 lengthA、lengthB；
  - 令较长链表的指针先行 lengthA-lengthB 步；
  - 然后两条链表的指针同步前进，依次比较当前节点是否相同；

```java
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
```

# 2. Summary

- 参见 LeetCode 160 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.