[TOC]

# 版权声明
- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；


# 1. LeetCode 589
- 递归：
  - 时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 最坏情况下的空间复杂度：$O(n)$；

# 2. 递归
- 解题思路：借助递归实现前序遍历；
- 难点：处理子节点的顺序应为从左到右；

```java
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

# 3. 迭代
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

# References
[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.