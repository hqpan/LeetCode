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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (root.left == null && root.right == null)
            return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

// Approach 2: Iteration
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack<TreeNode> stackNode = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        stackNode.push(root);
        stackSum.push(sum);
        while (!stackNode.isEmpty())
        {
            TreeNode tempNode = stackNode.pop();
            int tempSum = stackSum.pop();
            tempSum -= tempNode.val;
            if (tempNode.left == null && tempNode.right == null && tempSum == 0)
                return true;
            if (tempNode.left != null)
            {
                stackNode.push(tempNode.left);
                stackSum.push(tempSum);
            }
            if (tempNode.right != null)
            {
                stackNode.push(tempNode.right);
                stackSum.push(tempSum);
            }
        }
        return false;
    }
}
