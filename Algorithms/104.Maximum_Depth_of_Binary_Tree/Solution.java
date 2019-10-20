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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;    
    }
}

// Approach 2: Iteration
class Solution {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        Stack<st> stack = new Stack<>();
        stack.push(new st(root, 1));
        while (!stack.empty())
        {
            st temp = stack.pop();
            TreeNode node = temp.getNode();
            int depth = temp.getDepth();
            if (node != null)
            {
                ans = Math.max(ans, depth);
                stack.push(new st(node.left, depth + 1));
                stack.push(new st(node.right, depth + 1));
            }
        }
        return ans;  
    }     
}

public class st {		// 可用 Java 类库中的键值对实现; 
    private TreeNode node;
    private int depth;

    public st(TreeNode node, int depth)
    {
        this.node = node;
        this.depth = depth;
    }

    public TreeNode getNode()
    {
        return node;
    }

    public int getDepth()
    {
        return depth;
    }
}
