[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 105
## 1.1 复杂度分析
- 递归：
  - 时间复杂度：$O(n)​$；
  - 空间复杂度：$O(n)​$；
- 解题思路：
  - E.g. 前序遍历 preorder = [3,9,20,15,7]，中序遍历 inorder = [9,3,15,20,7]；
  - 前序遍历中，先访问根节点，然后访问左子树中各个节点，最后访问右子树中各个节点，由此可知根节点值为3；
  - 中序遍历中，先访问左子树中各个节点，然后访问根节点，最后访问右子树中各个节点，由此可知 [9] 为左子树中的节点，而 [15, 20, 7] 为右子树中的节点；
  - 对左子树和右子树重复执行上述步骤，即可依次求得各子树的根节点；

## 1.2 递归
- 难点：
  - Q1：两种方法的区别？
    - Approach 1：将表示左子树和右子树的数组作为参数传递给各方法；
    - Approach 2：将数组 preorder 和 inorder 作为全局参数，将表示左子树和右子树的起始和终止索引，作为参数传递给各方法；
  - A1：Approach 2 效率更高；
  - Q2：两种方法的区别？
    - Approach 1：使用循环结构，从中序遍历结果中找出根节点及其索引；
    - Approach 2：将中序遍历结果存入哈希表中，从哈希表中获取根节点及其索引；
  - A2：Approach 2 的时间开销为常数级别；

```java
class Solution {
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++)
            st.put(inorder[i], i);
        return buildTree(0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int preStart, int inStart, int inEnd) { 
        if ((preStart > preorder.length) || (inStart > inEnd))
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = st.get(root.val);
        root.left = buildTree(preStart + 1, inStart, index - 1);
        root.right = buildTree(preStart + index - inStart + 1, index + 1, inEnd);
        return root;
    }
}
```

# 2. LeetCode 106
## 2.1 复杂度分析
- LeetCode 106 和 105 对比：
  - 后序遍历中，先访问左子树中各个节点，然后访问右子树中各个节点，最后访问根节点；
  - 其余处理均类似于 LeetCode 105；
- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；



## 2.2 递归
```java
class Solution {
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++)
            st.put(inorder[i], i);
        return buildTree(0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode buildTree(int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || 0 > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = st.get(root.val);
        root.left = buildTree(inStart, index - 1, postEnd - inEnd + index - 1);
        root.right = buildTree(index + 1, inEnd, postEnd - 1);
        return root;
    }
}
```



# 3. LeetCode 889

## 3.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n^2)$；
  - 空间复杂度：$O(n)$；
- 解题思路：
  - E.g. 前序遍历 pre = [1,2,4,5,3,6,7]，后序遍历 post = [4,5,2,6,7,3,1]；
  - 由前序遍历结果可知，根节点值为1，且左子树的根节点值为2；
  - 由后序遍历结果可知，左子树的根节点2左侧的部分 [4, 5, 2] 为左子树，右侧的部分 [6, 7, 3] 为右子树；
  - 对左子树和右子树重复执行上述步骤，即可依次求得各子树的根节点；



## 3.2 递归

- 难点：
  - Q1：在检测边界条件时，为什么不使用`if (preStart > preEnd || postStart > postEnd)`？
  - A1：前序遍历和中序遍历的子数组长度始终保持一致，`preStart > preEnd`等价于`postStart > postEnd`，因此检测一个表达式即可；
  - 注意：LeetCode 889 的边界条件不同于 LeetCode 105 & 106，即使用`preStart > preEnd`和`preStart == preEnd`作为边界条件，当子数组中无元素或仅有一个元素时，返回相应结果；
  - Q2：为什么需要额外检测子数组中仅有一个元素的情况？
  - A2：因为程序中使用`pre[preStart + 1]`，用于获取左子树的根节点，为了防止`preStart + 1`访问数组越界，需要将数组中仅有一个元素的情况单独处理；

```java
class Solution {
    int[] pre;
    int[] post;
    HashMap<Integer, Integer> st = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        for (int i = 0; i < post.length; i++)
            st.put(post[i], i);
        return constructFromPrePost(0, pre.length - 1, 0);
    }

    public TreeNode constructFromPrePost(int preStart, int preEnd, int postStart) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd)
            return root;       
        int index = st.get(pre[preStart + 1]) - postStart;
        root.left = constructFromPrePost(preStart + 1, preStart + index + 1, postStart);
        root.right = constructFromPrePost(preStart + index + 2, preEnd, postStart + index + 1);
        return root;
    }
}
```



# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.