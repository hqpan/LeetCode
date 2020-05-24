/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution of LeetCode 104 & Offer 55-I
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// Solution of Offer 55-II
// Approach 1: 自顶向下递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        int diff = Math.abs(leftDepth - rightDepth);
        return (diff <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// Solution of Offer 55-II
// Approach 2: 自底向上递归
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth == -1 || rightDepth == -1)
            return -1;        
        return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}