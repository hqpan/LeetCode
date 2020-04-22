[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 147

## 1.1 复杂度分析

- 迭代：插入排序，稳定排序；
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(1)$；

## 1.2 迭代

- 解题思路：
  - 未排序节点的插入位置可能有3种情况：
    - 插入到链表头部，作为首节点；
    - 插入到链表中间，作为中间节点；
    - 插入到链表尾部，作为尾结点；
  - 插入排序：
    - 外循环：遍历链表各节点，作为待插入节点；
    - 内循环：从链表首节点开始遍历链表，寻找插入位置；
- 代码解读：
  - 创建辅助头节点`helper`，统一3种插入情况，使程序更简洁；
    - 插入位置在`helper`和`head`之间；
    - 插入位置在某2个中间节点之间；
    - 插入位置在尾结点和空节点（null）之间；
  - `curr.next.val < unsorted.val`：
    - 使用`curr.next`节点的值与`unsorted`节点的值比较，作为判断条件，而不使用`curr`节点参与比较；
    - 可知插入位置在`curr`和`curr.next`之间；
    - 若使用`curr`节点参与比较，则插入位置在`curr`之前，由于题中为单链表，不便表示当前节点的前驱节点；

```java
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
```

# 2. LeetCode 148

## 2.1 复杂度分析

- 递归：归并排序，稳定排序；
  - 时间复杂度：$O(nlogn)$；
  - 空间复杂度：$O(n)$；

## 2.2 递归

- 解题思路：
  - 使用快慢指针，找到链表中点`slow`；
  - 截断链表：令`slow.next = null`；
  - 对截断后的左右两个子链表递归执行排序操作；
  - 对排序后的两个子链表执行归并操作，整合为一个排序链表；

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode helper = new ListNode(-1);
        ListNode curr = helper;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return helper.next;
    }
}
```

# 3. Summary

- 参见 LeetCode 147 & 148 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.