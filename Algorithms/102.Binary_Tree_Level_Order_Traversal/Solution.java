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
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return list;
        bfs(root, 0);
        return list; 
    }

    private void bfs(TreeNode node, int floor)
    {
        if (list.size() == floor)
            list.add(new ArrayList<Integer>());
        list.get(floor).add(node.val);
        if (node.left != null)
            bfs(node.left, floor + 1);
        if (node.right != null)
            bfs(node.right, floor + 1);
    }
}

// Approach 2: Iteration
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();  
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();     
        queue.add(root);
        while (!queue.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(temp);
        }
        return list;
    }
}
