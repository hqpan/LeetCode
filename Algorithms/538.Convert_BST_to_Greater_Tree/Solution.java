// Approach 1: Recursion
class Solution {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null)
        {
            convertBST(root.right);
            sum += root.val;
            root.val = sum; 
            convertBST(root.left);
        }
        return root;
    }
}

// Approach 2: Iteration
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while ((!stack.isEmpty()) || (node != null))
        {
            while (node != null)
            {
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }
}
