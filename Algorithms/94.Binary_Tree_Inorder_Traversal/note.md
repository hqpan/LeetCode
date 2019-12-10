[TOC]


# 1. LeetCode 94
- 递归：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 莫里斯遍历：==unsolved==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

# 2. 递归

- 解题思路：通过递归缩小问题规模；

# 3. 迭代
![在这里插入图片描述](https://img-blog.csdnimg.cn/20191210145532172.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L01heGltaXplMQ==,size_16,color_FFFFFF,t_70)
- 解题思路：
  - 使用栈暂存待访问的节点；
  - 使用一个节点类型（TreeNode）的变量，指示下一步需要访问的节点；
  - 递归终止条件：栈为空且指示变量为空；
  - 核心步骤：
    - 循环访问当前节点的左节点，直至指示变量为空；
    - 将当前节点的值添加到动态数组中；
    - 将当前节点的右子节点赋给指示变量；
- 注意：该题的递归解法类似于 LeetCode 538，是一种典型递归案例；
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {        
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null)
        {
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
```
