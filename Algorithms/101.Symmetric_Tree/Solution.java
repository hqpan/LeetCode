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
        return mirror(root, root);
    }

    private boolean mirror(TreeNode root1, TreeNode root2)
    {
        if ((root1 == null) && (root2 == null))
            return true;
        if ((root1 == null) || (root2 == null))
            return false;
        return ((root1.val == root2.val) && mirror(root1.left, root2.right) && mirror(root1.right, root2.left));
    }
}

// Approach 2: Iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if ((node1 == null) && (node2 == null))
                continue;
            if ((node1 == null) || (node2 == null))
                return false;
            if (node1.val != node2.val)
                return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
