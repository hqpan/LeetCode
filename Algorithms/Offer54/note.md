[TOC]



# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. 剑指 Offer 54

## 1.1 复杂度分析

- DFS：中序遍历，==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 DFS

- 解题思路：
  - 若中序遍历二叉搜索树，所得序列为递增排序；
  - 若中序遍历时，先处理右子树，然后处理当前节点，最后处理左子树，所得序列为递减排序；
  - 每遍历一个值，令 k 值减1；
  - 当$k=0$时，对应节点即为所求；

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
    private int k;
    private int res;
    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            throw new RuntimeException("Invalid input!");
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        --k;
        if (k == 0)
            res = node.val;
        dfs(node.left);
    }
}
```

# 2. Summary

- 无需复习；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.