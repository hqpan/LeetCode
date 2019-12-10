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
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {        
        dfs(root);
        return list;
    }

    private void dfs(TreeNode node)
    {
        if (node == null)
            return ;
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}

// Approach 2: Iteration 2-1, DFS, 使用指示变量 curr
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {        
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        return list;
    }
}

// Approach 2: Iteration 2-2, DFS
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { 
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right); 
            if (temp.left != null)
                stack.push(temp.left);            
        }
        return list;
    }
}
