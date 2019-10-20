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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if ((root.left == null) && (root.right == null))
            return 1;
        int minDepth = Integer.MAX_VALUE;   
        if (root.left != null)      
            minDepth = Math.min(minDepth, minDepth(root.left));
        if (root.right != null)
            minDepth = Math.min(minDepth, minDepth(root.right));
        return minDepth + 1;
    }
}

// Approach 2: Iteration, Depth-First-Search
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Stack<st> stack = new Stack<>();
        stack.push(new st(root, 1));
        int ans = Integer.MAX_VALUE; 
        while (!stack.empty())
        {
            st temp = stack.pop();
            TreeNode node = temp.getNode();
            int depth = temp.getDepth();
            if ((node.left == null) && (node.right == null))
                ans = Math.min(ans, depth);    
            if (node.left != null)
                stack.push(new st(node.left, depth + 1));
            if (node.right != null)
                stack.push(new st(node.right, depth + 1));
        }
        return ans;
    }
}

public class st {
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

// Approach 3: Iteration, Breadth-First-Search
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<st> queue = new LinkedList<>();       
        queue.add(new st(root, 1));
        int minDepth = 0;
        while (queue.size() != 0)
        {
            st temp = queue.poll();
            TreeNode node = temp.getNode();
            minDepth = temp.getDepth();
            if ((node.left == null) && (node.right == null))
                return minDepth;
            if (node.left != null)
                queue.add(new st(node.left, minDepth + 1));
            if (node.right != null)
                queue.add(new st(node.right, minDepth + 1));
        }
        return -1;
    }
}

public class st {
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

