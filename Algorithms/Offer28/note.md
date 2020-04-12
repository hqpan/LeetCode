[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 101 & 剑指 Offer 28

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 28；

# 2. 递归

- 解题思路：
  - 从树的根节点出发，访问该树两次，E.g. `symmetric(root, root)`；  
  - 若两棵子树为对称子树，则满足以下条件：
    - 两棵子树根节点的值相等；
  	- 其中一棵子树的根节点的左子节点，与另一棵子树的右子节点值相等；
  	- 其中一棵子树的根节点的右子节点，与另一棵子树的左子节点值相等；

```java
// Approach 1: Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;
        return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
}
```

# 3. 迭代
- 解题思路：
  - 从根节点出发，使用两次 BFS 遍历所有节点，在逐层遍历的过程中，两次 BFS 分别从左到右、从右到左将节点加入队列；
  - 对于对称二叉树，两次 BFS 加入队列中的节点值相等；

```java
// Approach 2: Iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            if (temp1 == null && temp2 == null)
                continue;
            if (temp1 == null || temp2 == null || temp1.val != temp2.val)
                return false;
            queue.add(temp1.left);
            queue.add(temp2.right);
            queue.add(temp1.right);
            queue.add(temp2.left);
        }
        return true;
    }
}
```

# 4. Summary

- 无需复习；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.