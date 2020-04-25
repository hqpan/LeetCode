[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 112

## 1.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：
    - 最好情况：树是平衡的，$O(n)$；
    - 最坏情况：树是不平衡的，$O(log\space n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：
    - 最好情况：树是平衡的，$O(n)$；
    - 最坏情况：树是不平衡的，$O(log\space n)$；
- 相似的题：
  - LeetCode 113，剑指 Offer 34；
  - LeetCode 437；

## 1.2 递归
- 解题思路：使用 DFS 遍历所有节点，计算所有可能路径的数值之和；
- 难点：节点之和的保存和传递方式；
- 解决方案：
  - 可创建一个变量，用于保存从根节点至当前节点的累加和，该变量需要作为递归调用函数的参数；
  - 为了不创建额外的变量，可对`sum`参数做减法，不断使其减去当前节点的值，若在某个叶节点处，`sum`值减为0，则表明存在满足题意的路径；反之则不存在满足题意的路径；

```java
// Approach 1: Recursion
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
```

## 1.3 迭代
- 解题思路：同递归；
- 难点：当前节点累计路径之和的保存和使用方式；
- 解决方案：
  - 创建一个栈用于保存待访问的节点；
  - 创建一个栈用于保存当前节点累计路径之和；
  - 对上述两个栈同步进行入栈和出栈操作；

```java
// Approach 2: Iteration
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stackNode.push(root);
        stackSum.push(sum);
        while (!stackNode.isEmpty())
        {
            TreeNode tempNode = stackNode.pop();
            int tempSum = stackSum.pop();
            tempSum -= tempNode.val;
            if (tempNode.left == null && tempNode.right == null && tempSum == 0)
                return true;
            if (tempNode.left != null)
            {
                stackNode.push(tempNode.left);
                stackSum.push(tempSum);
            }
            if (tempNode.right != null)
            {
                stackNode.push(tempNode.right);
                stackSum.push(tempSum);
            }
        }
        return false;
    }
}
```

# 2. LeetCode 113 & 剑指 Offer 34

## 2.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：
    - 最好情况：树是平衡的，$O(n)$；
    - 最坏情况：树是不平衡的，$O(log\space n)$；

## 2.2 递归

- 解题思路：
  - 确定遍历二叉树的方式：因为需要首先检查父节点的值，然后检查子节点的值，所以采用前序遍历；
  - 为返回目标和路径，需要创建`LinkedList`记录当前路径；
    - `LinkedList`类提供`pollLast()`方法，便于删除集合中的尾元素，而`List`接口中未声明该方法；
    - 将当前节点值添加至`row`中，然后递归处理左、右子节点；
    - 从`row`中删除当前节点值；
  - ==难点==：使用`res.add(new LinkedList(row));`，而非`res.add(row);`？
    - 前者的含义：创建一个`LinkedList`，其中元素值为与`row`相同，然后将该`LinkedList`添加至`res`中；
    - 后者的含义：将`row`的引用添加至`res`中，当`row`在后续操作中被修改时，`res`中的结果也将被更改；

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> row = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        detect(root, sum);
        return res;
    }
    
    public void detect(TreeNode root, int sum) {
        if (root == null)
            return;
        row.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0)
            res.add(new LinkedList(row));
        detect(root.left, sum);
        detect(root.right, sum);
        row.pollLast();
    }
}
```

# 3. LeetCode 437

## 3.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：
    - 最好情况：树是平衡的，$O(log\space n)$；
    - 最坏情况：树是不平衡的，$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：
    - 最好情况：树是平衡的，$O(log\space n)$；
    - 最坏情况：树是不平衡的，$O(n)$；

## 3.2 递归

- 解题思路：遍历所有节点，对每个节点计算所有可能路径的数值之和，统计符合要求的路径数量；

```java
// Approach 1: Recursion
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum); 
    }

    private int count(TreeNode node, int sum)
    {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0) + count(node.left, sum - node.val) + count(node.right, sum - node.val);
    }
}
```

## 3.3 迭代

- 解题思路：同递归，需要使用二重循环；
  - 外循环遍历所有节点；
  - 内循环统计以当前节点为根节点的子树中，所有符合要求的路径数量；
- 解决方案：
  - 创建一个栈，用于保存外循环中待访问的节点；
  - 创建一个栈，用于保存内循环中待访问的节点；
  - 创建一个栈，用于保存内循环中当前节点累计路径之和；
  - 对上述后两个栈同步进行入栈和出栈操作；

```java
// Approach 2: Iteration
class Solution {
    public int pathSum(TreeNode root, int sum) {
        int ans = 0;
        if (root == null)
            return ans;
        Stack<TreeNode> outer = new Stack<>();
        Stack<TreeNode> inner = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        outer.push(root);
        while (!outer.isEmpty())
        {
            TreeNode node = outer.pop();
            inner.push(node);
            nums.push(sum);
            while (!inner.isEmpty())
            {
                TreeNode temp = inner.pop();
                int currSum = nums.pop() - temp.val;
                if (currSum == 0)
                    ans++;
                if (temp.left != null)
                {
                    inner.push(temp.left);
                    nums.push(currSum);
                }
                if (temp.right != null)
                {
                    inner.push(temp.right);
                    nums.push(currSum);
                }
            }
            if (node.left != null)
                outer.push(node.left);
            if (node.right != null)
                outer.push(node.right);
        }
        return ans;
    }
}
```

# 4. Summary

## 4.1 Grammar

- `java.util.LinkedList`：
  - `public LinkedList(Collection<? extends E> c)`：以`Collection`变量作为参数，该构造器函数将创建一个`LinkedList`，其中各元素值与参数中各元素值相同；

## 4.2 算法设计

- 参见 LeetCode 113 解题思路；
- LeetCode 112、437 也可适度复习；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.