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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return t1;
        if (t1 == null)
            return t2;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

// Approach 2 : Iteration
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)                             
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});        
        while (!stack.empty())                   
        {
            TreeNode[] temp = stack.pop();
            if (temp[1] == null)		// 将节点压入堆栈前，已确保temp[0]不为空；
                continue;
            temp[0].val += temp[1].val;
            if (temp[0].left == null)
                temp[0].left = temp[1].left;
            else
                stack.push(new TreeNode[] {temp[0].left, temp[1].left});

            if (temp[0].right == null)
                temp[0].right = temp[1].right;
            else
                stack.push(new TreeNode[] {temp[0].right, temp[1].right});    
        }
        return t1;
    }
}
