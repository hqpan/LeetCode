@[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 206
- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 难点：原地将链表反向，新建反向链表将增大空间开销；

# 2. 递归
- 解题思路：对源程序的逐行解读如下；
  - 对`null`和单一节点，无需执行反向操作，返回`head`即可；
  - `ListNode temp = reverseList(head.next)`，递归调用逐个调整节点之间的连接关系，返回整条链表新的`newHead`结点；
  - 将当节点及后继节点之间的连接关系反向；
  - 返回整条链表新的`newHead`结点；

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
```

# 3. 迭代
- 解题思路：对源程序的逐行解读如下；
  - 暂存前驱节点和当前节点；
  - 从链表中的第一个节点开始，逐个调整节点之间的连接关系；
  - 更新前驱节点和当前节点；

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
```


# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.