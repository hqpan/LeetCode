// Approach 1: Recursion
class Solution {
    public boolean isValidBST(TreeNode root) {
        return detection(root, null, null);
    }

    private boolean detection(TreeNode node, Integer lower, Integer upper)
    {
        if (node == null)
            return true;
        if (lower != null && node.val <= (int)lower)
            return false;
        if (upper != null && node.val >= (int)upper)
            return false;
        return detection(node.left, lower, node.val) && detection(node.right, node.val, upper);
    }
}

// Approach 2: Iteration
class Solution {
    Stack<TreeNode> stackNode = new Stack<>();
    Stack<Integer> stackLower = new Stack<>();
    Stack<Integer> stackUpper = new Stack<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        update(root, null, null);
        while (!stackNode.isEmpty())
        {
            TreeNode node = stackNode.pop();
            Integer lower = stackLower.pop();
            Integer upper = stackUpper.pop();
            if (lower != null && node.val <= lower)
                return false;
            if (upper != null && node.val >= upper)
                return false;
            if (node.left != null)
                update(node.left, lower, node.val);
            if (node.right != null)
                update(node.right, node.val, upper);
        }
        return true;
    }

    private void update(TreeNode node, Integer lower, Integer upper)
    {
        stackNode.push(node);
        stackLower.push(lower);
        stackUpper.push(upper);
    }
}

// Approach 3: Inorder traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        double lastValue = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (lastValue >= root.val)
                return false;
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }
}

