[TOC]


# 1. LeetCode 102
- 递归：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 迭代：
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；

# 2. 带有层数参数的递归
- 解题思路：
  - 为将各节点的值分层存入二维 List 中，应使用 BFS 进行层次遍历；
- 难点：遍历过程中需要判断某个节点位于哪一层；
- 解决方案：执行广度优先搜索的函数应具备两个形参，即节点和层数；

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

# 3. 区分层数的迭代
- 解题思路：同递归；
- 难点：遍历过程中需要判断某个节点位于哪一层；
- 解决方案：设定内循环的循环次数为队列的大小，处理当前队列中的所有节点，即完成当前层的访问；

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
