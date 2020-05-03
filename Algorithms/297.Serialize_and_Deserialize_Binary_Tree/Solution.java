/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach 1: BFS
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

// Approach 2: DFS
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