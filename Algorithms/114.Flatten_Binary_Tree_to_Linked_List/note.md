[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 114

## 1.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 递归

- 解题思路：
  - 由题意可知，以前序遍历的顺序构建单链表；
  - 令`root.right`指向左子树，令`root.left`为空；
  - 递归调用辅助函数将左子树转换为单链表，循环求解单链表的尾节点；
  - 令单链表的尾节点指向右子树，递归调用辅助函数将右子树转换为单链表；

```java
class Solution {
    public void flatten(TreeNode root) {
        unfold(root);
    }

    public TreeNode unfold(TreeNode node) {
        if (node == null)
            return null;
        TreeNode temp = node.right;
        node.right = unfold(node.left);
        node.left = null;
        TreeNode curr = node;
        while (curr.right != null)
            curr = curr.right;
        curr.right = unfold(temp);
        return node;
    }
}
```

# 2. 剑指 Offer 36

## 2.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 2.2 递归
- 解题思路：
  - 二叉搜索树：父节点的值大于左子节点，小于右子节点；
  - 遍历方式：中序遍历，可实现由小到大遍历二叉搜索树；
  - 子问题：若左子树已转换为双向链表，将当前节点加入双向链表中，再处理右子树；
    - Q：节点加入链表的顺序能否为“左子树-右子树-当前节点”？
    - A：不能；
      - 若按照原有方法，由左至右延伸链表，`head`变量仅需修改一次；
      - 若按照“左子树-右子树-当前节点”顺序，各节点加入链表的顺序不是从左到右，`head`、`tail`变量将被频繁修改，不便确定当前节点插入链表的位置；
- 难点：
  - 需要对已转换的子链表保存`head`和`tail`引用；
  - 考虑到函数返回值仅能提供一个引用变量，因此将`head`和`tail`作为全局变量；

```java
class Solution {
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        connect(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void connect(Node node) {
        if (node == null)
            return;
        connect(node.left);
        if (tail != null)
            tail.right = node;
        else
            head = node;
        node.left = tail;
        tail = node;
        connect(node.right);
    }
}
```

# 3. Summary

- 参见 LeetCode 114、剑指 Offer 36 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.