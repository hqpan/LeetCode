[TOC]


# 1. LeetCode 112
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

# 2. 递归
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

# 3. 迭代
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
