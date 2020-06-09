[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 21 & 剑指 Offer 25

## 1.1 复杂度分析

- 递归：==无需复习==
  - 时间复杂度：$O(n+m)$；
  - 空间复杂度：$O(n+m)$，递归调用隐式使用栈空间；
- 迭代：==无需复习==
  - 时间复杂度：$O(n+m)$；
  - 空间复杂度：$O(1)$；
- 相同问题：剑指 Offer 25；

## 1.2 递归
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

## 1.3 迭代
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

# 2. LeetCode 23

## 2.1 复杂度分析

- 最小堆：
  - 时间复杂度：$O(nlogk)$；
  - 空间复杂度：$O(k)$；

## 2.2 最小堆

- 解题思路：
  - 在 LeetCode 21 的基础上，链表数量从 2 增加至 k；
  - 为快速找出 k 个链表的头结点最小值，使用最小堆，求解 k 个值中最小值的时间复杂度为$O(logk)$；
  - 令当前节点指向堆弹出的最小节点即可；

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        Queue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode node : lists)
            if (node != null)
                heap.add(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null)
                heap.add(tail.next);
        }
        return head.next;
    }
}
```

# 3. Summary

## 3.1 Grammar

- `java.util.PriorityQueue`：非抽象类；

  - 若优先队列中存放自定义类型数据，则需提供比较器；
  - `Queue<ListNode> heap = new PriorityQueue<>((x, y) -> x.val - y.val)`；

- `java.util.Queue`：接口；

  - `add()`；
  - `peek()`；
  - `poll()`；
  - `remove()`；

  - `isEmpty`；
  - `Iterator<E> iterator()`；

## 3.2 算法设计

- 参见 LeetCode 23 解题思路，用堆求解多个值中的最大最小值，插入和删除元素的时间复杂度均为$O(logn)$；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.