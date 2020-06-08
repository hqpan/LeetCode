[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 235 & 剑指 Offer 68-I

## 1.1 复杂度分析

- 递归：
  
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(1)$；
- 相同的题：剑指 Offer 68-I；

## 1.2 递归

- 解题思路：
  - 二叉搜索树中，当前节点的值大于左子节点的值，小于右子节点的值；
  - 自根节点开始进行如下判断：
    - 若当前节点值小于`p`、`q`的值，则继续访问右子节点；
    - 若当前节点值大于`p`、`q`的值，则继续访问左子节点；
    - 否则表明当前节点值位于`p`、`q`的值之间，则该节点即为公共祖先节点；

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

// Approach 1: Recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
```

## 1.3 迭代

- 解题思路：同迭代；

```java
// Approach 2: Iteration
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
        return null;
    }
}
```

# 2. LeetCode 236 & 剑指 Offer 68-II

## 2.1 复杂度分析

- 提取链表：

  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 举一反三：
  - 相同的题：剑指 Offer 68-II；
  - 相似的题：对于一棵含有指向父节点的指针的二叉树，求解任意两个节点`p`、`q`的公共祖先节点；
    - 通过指向父节点的指针，可得从`p`至根节点的链表；
    - 同理，可得从`q`至根节点的链表；
    - 问题转换为求解两条链表的首个公共节点；
    - 使用哈希表即可求解；

## 2.2 提取链表

- 解题思路：
  - 相较于 2.1 中已求解“含有指向父节点指针的二叉树”的公共祖先问题，LeetCode 236 中的二叉树不含指向父节点的指针；
  - 使用 DFS 遍历二叉树，保存从根节点至`p`的路径，同理可得从根节点至`q`的路径；
  - 等价于得到了从`p`、`q`到根节点的两条链表；
  - 问题转换为求解两条链表的首个公共节点；

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> listP = new LinkedList<>();
        LinkedList<TreeNode> listQ = new LinkedList<>();
        dfs(root, p, listP);
        dfs(root, q, listQ);

        HashMap<TreeNode, Integer> st = new HashMap<>();
        while (!listP.isEmpty())
            st.put(listP.pollLast(), 1);
        while (!listQ.isEmpty()) {
            TreeNode temp = listQ.pollLast();
            if (st.containsKey(temp))
                return temp;
        }
        return null;
    }

    public boolean dfs(TreeNode node, TreeNode target, LinkedList list) {
        if (node == null)
            return false;
        list.addLast(node);
        if (node.equals(target))
            return true;
        boolean ans = dfs(node.left, target, list) || dfs(node.right, target, list);
        if (!ans)
            list.pollLast();
        return ans;
    }
}
```

# 3. Summary

- 参见 LeetCode 235、236 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.