// Approach 1: Recursion
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max - 1;
    }

    private int depth(TreeNode node)
    {
        if (node == null)
            return 0;
        int lengthL = depth(node.left);
        int lengthR = depth(node.right);
        max = Math.max(lengthL + lengthR + 1, max);
        return Math.max(lengthL, lengthR) + 1;
    }
}
