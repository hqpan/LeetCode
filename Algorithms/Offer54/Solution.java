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
    private int k;
    private int res;
    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            throw new RuntimeException("Invalid input!");
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.right);
        --k;
        if (k == 0)
            res = node.val;
        dfs(node.left);
    }
}