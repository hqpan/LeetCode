[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 21 & 剑指 Offer 25
- 递归：
  - 时间复杂度：$O(n+m)$；
  - 空间复杂度：$O(n+m)$，递归调用隐式使用栈空间；
- 迭代：
  - 时间复杂度：$O(n+m)$；
  - 空间复杂度：$O(1)$；
- 相同问题：剑指 Offer 25；

# 2. 递归
- 解题思路：
  - 以2链表中值较小的首结点作为合并后的首结点；
  - 首节点确定后，递归调用完成后续链表合并；
  - 递归调用的结果返回给首节点的`next`变量；
- 代码鲁棒性：考虑链表可能为空；

```java
// Approach 1: Recursion
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

# 3. 迭代
- 解题思路：
  - 申明并创建一个首节点`head`；
  - 申明并创建一个指向当前节点的变量`curr`；
  - 在循环中逐个将原始链表中的节点合并到新链表中；
  - 返回`head.next`；
- 代码鲁棒性：考虑链表可能为空；

```java
// Approach 2: Iteration
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
```



# 4. Summary

- 无需复习；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.