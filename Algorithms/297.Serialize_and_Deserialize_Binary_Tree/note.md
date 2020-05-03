[TOC]

# 版权声明

- LeetCode 系列笔记来源于 LeetCode 题库[^1]，在个人思考的基础之上博采众长，受益匪浅；故今记此文，感怀于心，更多题解及程序，参见 Github[^2]；
- 该系列笔记不以盈利为目的，仅用于个人学习、课后复习及交流讨论；
- 如有侵权，请与本人联系（hqpan@foxmail.com），经核实后即刻删除；
- 本文采用 [署名-非商业性使用-禁止演绎 4.0 国际 (CC BY-NC-ND 4.0)](https://creativecommons.org/licenses/by-nc-nd/4.0/deed.zh) 协议发布；

# 1. LeetCode 297 & 剑指 Offer 37

## 1.1 复杂度分析

- BFS：==无需复习==
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- DFS：前序遍历；
  - 时间复杂度：$O(n)$；
  - 空间复杂度：$O(n)$；
- 相同的题：剑指 Offer 37；

## 1.2 BFS
- 解题思路：
  - 序列化：使用 BFS 遍历二叉树，读取各节点值和 null；
  - 反序列化：借助队列存放非空节点，序列中的2个值为当前节点的左、右子节点值；

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                builder.append("null,");
                continue;
            }
            builder.append(node.val + ",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] str = data.split(",");
        Integer[] values = new Integer[str.length];
        for (int i = 0; i < str.length; i++)
            values[i] = str[i].equals("null") ? null : Integer.parseInt(str[i]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.add(root);
        int index = 1;
        while (index <= values.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (values[index] == null) {
                node.left = null;
                index++;
            } else {
                node.left = new TreeNode(values[index++]);
                queue.add(node.left);
            }
            if (values[index] == null) {
                node.right = null;
                index++;
            } else {
                node.right = new TreeNode(values[index++]);
                queue.add(node.right);
            }
        }
        return root;
    }
}
```

## 1.3 DFS

- 解题思路：
  - 序列化：使用前序遍历二叉树，读取各节点值和 null；
    - Q：为什么使用前序遍历？
    - A：前序遍历访问顺序为“当前节点-左子树-右子树”，便于反序列化时构建节点间的连接；
  - 反序列化：将序列转换为`List`，便于删除已插入的节点值；
    - 创建当前节点；
    - 创建当前节点的左子节点；
    - 创建当前节点的右子节点；
    - 注意：若序列中对应的值为null，则返回null；

```java
// DFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder builder = new StringBuilder();
        return serializeDFS(root, builder).toString();
    }

    public StringBuilder serializeDFS(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null,");
            return builder;
        }
        builder.append(node.val + ",");
        builder = serializeDFS(node.left, builder);
        return serializeDFS(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] str = data.split(",");
        Integer[] values = new Integer[str.length];
        for (int i = 0; i < str.length; i++)
            values[i] = str[i].equals("null") ? null : Integer.parseInt(str[i]);
        List<Integer> list = new LinkedList<>(Arrays.asList(values)); 
        return deserializeDFS(list);
    }

    public TreeNode deserializeDFS(List list) {
        if (list.get(0) == null) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode((int) list.remove(0));
        node.left = deserializeDFS(list);
        node.right = deserializeDFS(list);
        return node;
    }
}
```



# 2. Summary

- 参见 LeetCode 297 中 DFS 解题思路；

# References

[^1]: https://leetcode-cn.com/u/hqpan/.
[^2]: https://github.com/hqpan/LeetCode.