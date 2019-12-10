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
    ArrayList<Integer> ans = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {        
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node)
    {
        if (node == null)
            return ;
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
    }
}

// Approach 2: Iteration, which is similar to LeetCode 538
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {        
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;     
        }
        return ans;
    }
}
