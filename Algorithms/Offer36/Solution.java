/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
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