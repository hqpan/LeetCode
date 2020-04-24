[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 102

## 1.1 复杂度分析

- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相关题型：
  - 相同的题：剑指 Offer 32-II；
  - 相似的题：剑指 Offer 32-I、32-III；

## 1.2 带有层数参数的递归
- 解题思路：
  - 递归调用过程隐含着栈调用，即为 DFS；
  - 为将各节点的值分层存入二维 List 中，应使用额外的参数表示当前节点所在层；
- 难点：遍历过程中需要判断某个节点位于哪一层；
- 解决方案：执行 DFS 的函数应具备两个形参，即当前节点和层数；

```java
// Approach 1: Recursion
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return list;
        bfs(root, 0);
        return list; 
    }

    private void bfs(TreeNode node, int floor)
    {
        if (list.size() == floor)
            list.add(new ArrayList<Integer>());
        list.get(floor).add(node.val);
        if (node.left != null)
            bfs(node.left, floor + 1);
        if (node.right != null)
            bfs(node.right, floor + 1);
    }
}
```

## 1.3 迭代
- 解题思路：
  - 创建一个辅助队列，用于完成 BFS；
  - 设定内循环的循环次数为队列的大小，处理当前队列中的所有节点，即完成当前层的访问；

```java
// Approach 2: Iteration
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();  // take notes
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();     // take notes
        queue.add(root);
        while (!queue.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
```

# 2. 剑指 Offer 32-I

- 解题思路：借助队列，完成 BFS；
- 难点：`ArrayList`中的`toArray()`只能返回`Object[]`，需要使用循环，将元素逐个写入`int[]`中；

```java
class Solution {
    public int[] levelOrder(TreeNode root) {        
        if (root == null)
            return new int[] {};
        ArrayList<Integer> nums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            nums.add(temp.val);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++)
            ans[i] = nums.get(i);
        return ans;
    }
}
```

# 3. 剑指 Offer 32-II

- 剑指 Offer 32-II 与 LeetCode 102 完全相同；

# 4. 剑指 Offer 32-III

- 解题思路：
  - 剑指 Offer 32-III 的遍历过程与 BFS 相似；
  - 在 BFS 遍历结果的基础上，将偶数层元素反序；
  - 创建一个辅助队列，完成 BFS；
  - 处理当前队列中所有节点，将其子节点存入队列中；
  - 若当前行为偶数行，则将当前队列中所有节点的遍历结果反序；
  - ==注意==：先将当前队列中所有节点的子节点存入队列，而后根据情况将当前层中节点反序，因此反序操作不影响下一层中节点的顺序（仍为 BFS 排序）；

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                row.add(temp.val);                    
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            if ((ans.size() & 1) == 1)
                Collections.reverse(row);
            ans.add(row);
        }
        return ans;
    }
}
```

# 5. Summary

## 5.1 Grammar

- interface：
  - `java.util.List`；
  - `java.util.Queue`；
- class：
  - `java.util.ArrayList`；
    - `ArrayList`中的`toArray()`只能返回`Object[]`，需要使用循环，将元素逐个写入`int[]`中；
  - `java.util.LinkedList`；
  - `java.util.Arrays`；
  - `java.util.Collections`；
    - `public static void reverse(List<?> list)`：将传入的`List`参数中所有元素反序，无返回值；
- 运算符优先级依次递减：
  - `==`、`!=`；
  - `&`；
  - `^`；
  - `|`；
  - `&&`；
  - `||`；

## 5.2 算法设计

- DFS、BFS 以来的数据结构：
  - DFS：栈；
  - BFS：队列；
- 二叉树的分层遍历：
  - 创建一个辅助队列，用于完成 BFS；
  - 设定内循环的循环次数为队列的大小，处理当前队列中的所有节点，即完成当前层的访问；
- 参见剑指 Offer 32-III 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.