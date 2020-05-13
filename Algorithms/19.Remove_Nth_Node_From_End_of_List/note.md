[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 19 & 剑指 Offer 22

## 1.1 复杂度分析

- 考察内容：
  - 双指针；
  
  - 代码鲁棒性设计：
    - 链表引用为空；
    - 若需求解链表中倒数第 k 个节点，但链表中不足 k 个节点；
    - `k<=0`；
- 单指针：2次遍历链表；==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 双指针：1次遍历链表;
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 举一反三：
  - 相同问题：LeetCode 19；
  - 相似问题：求解链表的中间节点；
    - 若链表长度为奇数，则返回中间节点值；
    - 若链表长度为偶数，则返回2个中间节点值中的任意一个即可；
    - Solution：双指针法，其中一个指针的前进速度是另一个指针的2倍；

## 1.2 单指针

- 解题思路：==无需复习==
  - 遍历链表，求得链表长度 n；
  - 将指针向前移动 n-k+1 步，此时指针指向的节点即为所求；
  - 缺点：需要遍历链表2次；

## 1.3 双指针

- 解题思路：
  - 定义两个指针`ahead`和`behind`；
  - 先令`ahead`前进 k-1 步；
  - 然后同时移动两个指针，直至`ahead`指向链表尾节点；
  - 此时`behind`指向的位置即为所求；

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
```



# 2. Summary

- 双指针法：适用于检索数组、链表中特定位置上的元素；
- 代码鲁棒性设计：考虑 k<= 0；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.