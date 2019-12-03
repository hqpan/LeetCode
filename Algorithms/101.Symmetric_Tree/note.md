[TOC]


# 1. 复杂度分析
- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

# 2. 递归

- 解题思路：
  - 从树的根节点出发，访问该树两次，E.g. root 1，root 2；  
  - 若两棵子树为对称子树，则满足以下条件：
    - 两棵子树根节点的值相等；
  	- 其中一棵子树的根节点的左子节点，与另一棵子树的右子节点值相等；
  	- 其中一棵子树的根节点的右子节点，与另一棵子树的左子节点值相等；
  - 返回条件：
    - 两节点的值均为空，则返回`true`；
    - 若一个节点的值为空，另一个节点的值不为空，则返回`false`；
    - 若两个节点的值均不为空，则进行递归调用；

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }

    private boolean mirror(TreeNode root1, TreeNode root2)
    {
        if ((root1 == null) && (root2 == null))
            return true;
        if ((root1 == null) || (root2 == null))
            return false;
        return ((root1.val == root2.val) && mirror(root1.left, root2.right) && mirror(root1.right, root2.left));
    }
}
```

# 3. 迭代
- 解题思路：
  - 从根节点出发，使用两次 BFS 遍历所有节点，在逐层遍历的过程中，两次 BFS 分别从左到右、从右到左将节点加入队列；
  - 对于对称二叉树，两次 BFS 加入队列中的节点值相等；
