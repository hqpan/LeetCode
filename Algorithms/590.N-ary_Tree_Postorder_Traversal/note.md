[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 145

## 1.1 时间复杂度分析

- 递归：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 迭代：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；

## 1.2 递归
- 递归方法：==无需复习==：

```java
// Approach 1: Recursion
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
```

## 1.3 迭代
- 解题思路：
  - 前序遍历：根节点-左子树-右子树；
  - 后序遍历：左子树-右子树-根节点；
  - 后序遍历结果的镜像：根节点-右子树-左子树；
    - 因此可使用类似于前序遍历的方法访问二叉树；
    - 注意先将左子节点入栈，后将右子节点入栈（恰与前序遍历顺序相反）；
- 难点：`LinkedList`类中的`addFirst()`方法，可将值逐个加入集合首部，从而得到反序结果；

```java
// Approach 2: Iteration
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return list;
    }
}
```

# 2. LeetCode 590

## 2.1 复杂度分析

- 递归：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 迭代：
  - 最坏情况下的时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- LeetCode 590：解题思路与 LeetCode 145 类似，==无需复习==；

## 2.2 递归

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// Approach 1: Recursion
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        for (Node node : root.children)
            postorder(node);
        list.add(root.val);
        return list;
    }
}
```

## 2.3 迭代

```java
// Approach 2: Iteration
class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.addFirst(node.val);
            for (Node temp : node.children)
                if (temp != null)
                    stack.push(temp);
        }
        return list;
    }
}
```

# 3. Summary

## 3.1 Grammar

- `foreach`语法：适用于数组和集合类；
- `java.util.List`：List 接口，`get()`和`size()`方法也可用于遍历；
  - `E get(int index)`；
  - `int size()`；
  - `boolean isEmpty()`；
  - `Object[] toArray()`；
- `java.util.LinkedList`：类；
  - `public void addFirst(E e)`：将元素逐个添加到集合首部，从而得到反序的结果；
  - `public void addLast(E e)`；
  - `public E getFirst()`；
  - `public E getLast()`；
  - `public E peekFirst()`；
  - `public E peekLast()`；
  - `public E pollFirst()`；
  - `public E pollLast()`；
  - `public int size()`；
  - `public Object[] toArray()`；

## 3.2 算法设计

- 后序遍历算法：
  - 前序遍历：根节点-左子树-右子树；
  - 后序遍历：左子树-右子树-根节点；
  - 后序遍历结果的镜像：根节点-右子树-左子树；
    - 因此可使用类似于前序遍历的方法访问二叉树；
    - 注意先将左子节点入栈，后将右子节点入栈（恰与前序遍历顺序相反）；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.