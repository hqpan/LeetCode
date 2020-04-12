/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Approach 1: Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null || node1.val != node2.val)
            return false;
        return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
}

// Approach 2: Iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();
            if (temp1 == null && temp2 == null)
                continue;
            if (temp1 == null || temp2 == null || temp1.val != temp2.val)
                return false;
            queue.add(temp1.left);
            queue.add(temp2.right);
            queue.add(temp1.right);
            queue.add(temp2.left);
        }
        return true;
    }
}