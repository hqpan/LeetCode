[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 104 & 剑指 Offer 55-I

## 1.1 复杂度分析

- 递归：

  - 时间复杂度：$O(n)$；

  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 53-I；

## 1.2 递归

- 解题思路：$当前节点的深度=max(左子树深度， 右子树深度) + 1$；

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
```

# 2. LeetCode 110 & 剑指 Offer 55-II

## 2.1 复杂度分析

  - 自顶向下递归：

    - 时间复杂度：$O(nlogn)$；
- 空间复杂度：$O(n)$；
- 自底向上递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
  - 相同的题：剑指 Offer 53-II；

## 2.2 自顶向下递归

  - 解题思路：
      - 使用 LeetCode 104 中的方法求解当前节点的左子树、右子树深度；
      - 判断以当前节点为根节点的树是否平衡；
      - 对每个节点执行该操作；
- 缺点：重复遍历同一节点；

  ```java
// Approach 1: 自顶向下递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int diff = Math.abs(leftDepth - rightDepth);
        return (diff <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
  ```

## 2.3 自底向上递归

- 解题思路：
  - 后序遍历访问顺序：左子树-右子树-当前节点；
  - 可借助后序遍历，比较当前节点的左右子树深度，判断以当前节点为根的子树是否平衡；
    - 若为平衡子树，则返回对应深度；
    - 若不为平衡子树，则返回-1；

```java
// Approach 2: 自底向上递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1)
            return -1;        
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
```

# 3. Summary

- 参见 LeetCode 104 & 110 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.