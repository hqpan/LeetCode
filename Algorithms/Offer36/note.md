[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 36

## 1.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 递归
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
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
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

# 2. Summary

## 2.1 数据结构

- 二叉树的中序遍历：每次函数调用中，均只对当前节点（父节点）做处理；

```java
public void dfs(Node root) {
    if (root == null)
        return;
    dfs(root.left);
    System.out.println(root.val);
    dfs(root.right);
}
```



## 2.2 算法设计

- 参见剑指 Offer 36 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.