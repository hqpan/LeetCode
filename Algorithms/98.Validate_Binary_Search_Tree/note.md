[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 98
- 递归：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 迭代：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 中序遍历：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；

# 2. 递归
- 解题思路：将问题拆解为对左子树和右子树的处理，缩小问题规模；
- 难点：
  - 不应求左右子树的最大值和最小值，该种方式将增加计算开销；
  - 应将父节点的值作为左子树的上界和右子树的下界；

```java
// Approach 1: Recursion
class Solution {
    public boolean isValidBST(TreeNode root) {
        return detection(root, null, null);
    }

    private boolean detection(TreeNode node, Integer lower, Integer upper)
    {
        if (node == null)
            return true;
        if (lower != null && node.val <= (int)lower)
            return false;
        if (upper != null && node.val >= (int)upper)
            return false;
        return detection(node.left, lower, node.val) && detection(node.right, node.val, upper);
    }
}
```

# 3. 迭代
- 解题思路：借助于栈，将递归方法转换为迭代；
- 难点：同递归；

```java
// Approach 2: Iteration
class Solution {
    Stack<TreeNode> stackNode = new Stack<>();
    Stack<Integer> stackLower = new Stack<>();
    Stack<Integer> stackUpper = new Stack<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        update(root, null, null);
        while (!stackNode.isEmpty())
        {
            TreeNode node = stackNode.pop();
            Integer lower = stackLower.pop();
            Integer upper = stackUpper.pop();
            if (lower != null && node.val <= lower)
                return false;
            if (upper != null && node.val >= upper)
                return false;
            if (node.left != null)
                update(node.left, lower, node.val);
            if (node.right != null)
                update(node.right, node.val, upper);
        }
        return true;
    }

    private void update(TreeNode node, Integer lower, Integer upper)
    {
        stackNode.push(node);
        stackLower.push(lower);
        stackUpper.push(upper);
    }
}
```

# 4. 中序遍历
- 解题思路：使用中序遍历所有节点，当且仅当先被访问的节点值小于后被访问的节点值时，满足题意；
- 难点：
  - 中序遍历的实现方法；
	- 使用 DFS 访问二叉树，借助栈保存被访问的左子节点，直至二叉树的叶节点；
	- 从栈中弹出该叶节点的父节点；
	- 访问该父节点的右子节点；
	- 重复上述三个步骤，即可实现中序遍历；
  - 为什么使用`Double.MAX_VALUE`而非`Integer.MAX_VALUE`？
    - 由题意可知，二叉树的节点值为整型；
    - 若使用`Integer.MAX_VALUE`作为下界，则可能出现节点值与下界相等的情况，造成逻辑错误；
```sql
// Approach 3: Inorder traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        double lastValue = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (lastValue >= root.val)
                return false;
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }
}
```

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.