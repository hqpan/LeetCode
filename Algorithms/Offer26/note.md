[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. 剑指 Offer 26
- 递归：
  - 时间复杂度：$O(nm)$；
  - 空间复杂度：$O(nm)$，递归调用隐式使用栈空间；
- 迭代：
  - 时间复杂度：$O(nm)$；
  - 空间复杂度：$O(1)$；

# 2. 递归
- 解题思路：
  - 遍历二叉树 A，对其中的每个节点执行检测；
  - 将 A 中以各节点为根节点的子树与二叉树 B 进行比较；
- 代码鲁棒性与简化：
  - `A == null || B == null`：由题意可知，空树不是任何树的子结构；
  - `B == null`：等价于`A == null && B == null`和`A != null && B == null`；
  - `A == null && B != null`：程序运行至此必满足`B != null`, 可省略；

```java
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) 
            return false;
        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean compare(TreeNode A, TreeNode B) {
        if (B == null) 
            return true;
        if (A == null || A.val != B.val)
            return false; 
        return compare(A.left, B.left) && compare(A.right, B.right);
    }
}
```

# 3. Summary
- 无需复习；



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.