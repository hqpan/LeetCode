[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. 剑指 Offer 33
- 递归、分治：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(n)$；

# 2. 递归
- 解题思路：
  - 二叉搜索树：根节点的值大于所有左子节点的值，小于所有右子节点的值；
  - 二叉树的后序遍历：左子树中各节点-右子树中各节点-根节点；
  - 遍历数组，找出左右子树的分界处；
    - 在遍历过程中，检测左右子树与根节点的大小关系；
    - 即可判断本层节点是否满足题意；
  - 对左、右子树分别执行递归调用；

```java
// Approach 1: Recursion, divide and conquer
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;
        return detect(postorder, 0, postorder.length - 1);
    }

    public boolean detect(int[] postorder, int lo, int hi) {
        if (lo >= hi)
            return true;
        int index = lo;
        while (postorder[index] < postorder[hi])
            index++;
        int tempIndex = index;
        while (postorder[index] > postorder[hi])
            index++;
        return index == hi && detect(postorder, lo, tempIndex - 1) && detect(postorder, tempIndex, hi - 1);
    }
}
```

# 3. Summary

- 二叉搜索树：根节点的值大于所有左子节点的值，小于所有右子节点的值；
- 二叉树的后序遍历：左子树中各节点-右子树中各节点-根节点；
- 相关概念：
  - 满二叉树：除叶节点外，各节点均有2个子节点；
  - 完全二叉树：若设二叉树的深度为h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左侧；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.