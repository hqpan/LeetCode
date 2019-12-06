[TOC]


# 1. LeetCode 538
- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 注意：二叉查找树的定义；
  - 二叉查找树，即二叉搜索树、二叉排序树；
  - 其中任一节点的值大于该节点的左子节点，小于该节点的右子节点；

# 2. 递归

- 解题思路：按各节点值由大到小的顺序，依次访问各节点，即先访问二叉查找树的最右侧节点，重复执行该步骤；


# 3. 迭代
- 解题思路：使用栈存储迭代过程中未处理的节点，遍历方式为反中序遍历；
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191206170701272.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L01heGltaXplMQ==,size_16,color_FFFFFF,t_70)

```java
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while ((!stack.isEmpty()) || (node != null))
        {
            while (node != null)
            {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
```

