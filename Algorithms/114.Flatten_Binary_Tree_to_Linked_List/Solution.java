// Solution of LeetCode 114
class Solution {
    public void flatten(TreeNode root) {
        unfold(root);
    }

    public TreeNode unfold(TreeNode node) {
        if (node == null)
            return null;
        TreeNode temp = node.right;
        node.right = unfold(node.left);
        node.left = null;
        TreeNode curr = node;
        while (curr.right != null)
            curr = curr.right;
        curr.right = unfold(temp);
        return node;
    }
}

// Solution of 剑指 Offer 36
class Solution {
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        connect(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void connect(Node node) {
        if (node == null)
            return;
        connect(node.left);
        if (tail != null)
            tail.right = node;
        else
            head = node;
        node.left = tail;
        tail = node;
        connect(node.right);
    }
}
