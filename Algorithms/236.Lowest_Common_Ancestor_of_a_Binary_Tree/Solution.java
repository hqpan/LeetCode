/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution of LeetCode 235, Approach 1: Recursion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

// Solution of LeetCode 235, Approach 2: Iteration
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                return root;
        }
        return null;
    }
}

// Solution of LeetCode 236
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> listP = new LinkedList<>();
        LinkedList<TreeNode> listQ = new LinkedList<>();
        dfs(root, p, listP);
        dfs(root, q, listQ);

        HashMap<TreeNode, Integer> st = new HashMap<>();
        while (!listP.isEmpty())
            st.put(listP.pollLast(), 1);
        while (!listQ.isEmpty()) {
            TreeNode temp = listQ.pollLast();
            if (st.containsKey(temp))
                return temp;
        }
        return null;
    }

    public boolean dfs(TreeNode node, TreeNode target, LinkedList list) {
        if (node == null)
            return false;
        list.addLast(node);
        if (node.equals(target))
            return true;
        boolean ans = dfs(node.left, target, list) || dfs(node.right, target, list);
        if (!ans)
            list.pollLast();
        return ans;
    }
}