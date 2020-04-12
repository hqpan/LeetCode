[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 226 & 剑指 Offer 27

- 递归：

  - 时间复杂度：$O(n)$；

  - 空间复杂度：在最坏情况下（即 skewed tree）为$O(n)$；

- 迭代：

  - 时间复杂度：$O(n)$；
  - 空间复杂度：在最坏情况下（即 skewed tree）为$O(n)$；

- 相同问题：剑指 Offer 27；

# 2. 递归

- 递归三要素：若递归次数过多，则效率低下，且有可能导致栈溢出；
  - 边界条件；
    - 满足边界条件时，递归前进；
    - 不满足边界条件时，递归后退；
  - 每次递归均使得问题规模变小；
  - 父问题与子问题不得重叠；
- 解题思路：
  - 遍历二叉树中的所有节点；
  - 交换当前节点的左子节点和右子节点，此时仅交换了左子树和右子树的根节点，但子树中的其它节点尚未交换；
  - 遍历过程中对各个节点执行上述步骤，即可得镜像二叉树；

```java
// Approach 1: Recursion
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
```

# 3. 迭代

- 求解流程：

  - 使用迭代的方式遍历二叉树；
- 交换各节点的左子节点和右子节点，同递归；
  

```java
// Approach 2: Iteration
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        return root;
    }
}
```

# 4. Summary

## 4.1 面试要点

- 先向面试官描述解题思路，然后编程求解；
- 对于抽象的、复杂的面试题，可借助举例、画图等方式，向面试官描述解题思路；

## 4.2 Java 语法

- `java.util Interface Queue<E>`：
  - 实例化：`Queue<E> queue = new LinkedList<>();`；
  - `public boolean add()`；
  - `public E peek()`；
    - 查看队列首部元素，但不删除该元素；
    - 若队列为空，则返回 null；
  - `public E poll()`；
    - 查看队列首部元素，并删除该元素；
    - 若队列为空，则返回 null；
  - `public E remove()`：返回队列首部元素，并删除该元素；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.