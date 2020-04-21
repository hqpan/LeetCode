[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 144

## 1.1 复杂度分析

- 递归：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 莫里斯遍历：==unsolved==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

## 1.2 递归

```java
// Approach 1: Recursion 
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {        
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node)
    {
        if (node == null)
            return ;
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
```

## 1.3 迭代

```java
// Approach 2: Iteration
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { 
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right); 
            if (temp.left != null)
                stack.push(temp.left);            
        }
        return list;
    }
}
```

# 2. LeetCode 589

## 2.1 复杂度分析

- 递归：==无需复习==
  - 时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 解题思路与 LeetCode 144 相似；

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
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        findList(root);
        return list;
    }

    private void findList(Node node)
    {
        if (node == null)
            return;
        list.add(node.val);
        for (Node temp : node.children)
            findList(temp);
    }
}
```

## 2.3 迭代

- 解题思路：借助栈实现前序遍历；
- 难点：同递归，可使用`Collections`类的`static void reverse(List<?> list)`方法，将`List`中所有对象反序，亦可借助于栈将所有元素反序；

```java
// Approach 2: Iteration
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null)
            return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            Node node = stack.pop();
            list.add(node.val);
            Stack<Node> reverse = new Stack<>();
            Collections.reverse(node.children);
            for (Node temp : node.children)
                stack.push(temp);
        }
        return list;
    }
}
```

# 3. Summary

- `java.util.Collections`：类，不同于`java.util.Collection`接口；
  - `public static void reverse(List<?> list)`：将`List`中元素反序；
- 迭代方法遍历二叉树：
  - 栈：深度优先；
  - 队列：广度优先；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.