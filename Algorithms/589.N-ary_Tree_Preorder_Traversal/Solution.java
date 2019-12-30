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


